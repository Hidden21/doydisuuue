package com.doyd.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.doyd.biz.IVisitRecordService;
import com.doyd.utils.DateUtil;
import com.doyd.utils.StringUtil;

@Controller
public class VisitController {

    @Autowired
    private IVisitRecordService visitService;

    /**
     * 问题访问页面
     */
    @RequestMapping(value = "/lt/visit.html", method = { RequestMethod.GET })
    public String visit(HttpServletRequest request, HttpServletResponse response) {
        String visitTag = ControllerContext.getCookies(request, "visitTag");
        if (StringUtil.isEmpty(visitTag)) {
            visitTag = DigestUtils.md5Hex(DateUtil.now()
                    + StringUtil.getRandomString(32) + "DOYD");
            ControllerContext.setCookies(response, "visitTag", visitTag);
            this.visitService.addVisitRecord(visitTag, 1);
        }
        ;
        return "/visit";
    }

    /**
     * 问题访问及答案页面
     */
    @RequestMapping(value = "/lt/attention.html", method = { RequestMethod.GET })
    public String attention(HttpServletRequest request,
            HttpServletResponse response) {
        String openId = request.getParameter("openId");
        String vfTag = request.getParameter("vfTag");
        String ghId = request.getParameter("ghId");
        String visitTag = ControllerContext.getCookies(request, "visitTag");
        this.visitService.upVisitRecord(visitTag, ghId, openId, vfTag);
        return "/attention";
    }

    /**
     * 问题访问页面
     */
    @RequestMapping(value = "/lt/visitIssue{pageId}.html", method = { RequestMethod.GET })
    public String visitIssue(HttpServletRequest request,
            HttpServletResponse response, @PathVariable int pageId) {
        String visitTag = ControllerContext.getCookies(request, "visitTag");
        if (StringUtil.isEmpty(visitTag)) {
            visitTag = DigestUtils.md5Hex(DateUtil.now()
                    + StringUtil.getRandomString(32) + "DOYD");
            ControllerContext.setCookies(response, "visitTag", visitTag);
            this.visitService.addVisitRecord(visitTag, pageId + 1);
        }
        ;
        pageId = pageId < 1 ? pageId : pageId;
        return "page" + pageId + "/visit";
    }

    /**
     * 问题访问及答案页面
     */
    @RequestMapping(value = "/lt/answer{pageId}.html", method = { RequestMethod.GET })
    public String answer(HttpServletRequest request,
            HttpServletResponse response, @PathVariable int pageId) {
        String openId = request.getParameter("openId");
        String vfTag = request.getParameter("vfTag");
        String ghId = request.getParameter("ghId");
        String visitTag = ControllerContext.getCookies(request, "visitTag");
        this.visitService.upVisitRecord(visitTag, ghId, openId, vfTag);
        pageId = pageId < 1 ? pageId : pageId;
        return "page" + pageId + "/attention";
    }

    /*
     * 错误地址
     */
    @RequestMapping(value = "/errorUrl.html", method = { RequestMethod.GET })
    public String errorUrl(HttpServletRequest request,
            HttpServletResponse response) {
        return "errorUrl";
    }
}
