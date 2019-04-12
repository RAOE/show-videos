package com.show.admin.scetc.exception;

import com.show.admin.scetc.utils.JSONResult;
import com.show.admin.scetc.utils.JsonUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
/**
 * 全局异常捕获
 */
public class XuYuanFengExceptionHandler {

    private static final Logger logger = Logger.getLogger(XuYuanFengExceptionHandler.class);
    private final String HTTP_HEADER = "X-Requested-With";
    /**
     * 统一异常处理
     *
     * @param exception exception
     * @return
     */
    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView processException(HttpServletRequest request, HttpServletResponse response, RuntimeException exception) {
        logger.info("自定义异常处理-RuntimeException");
        logger.error(exception.getMessage());
        //如果当前的异常的类型为ajax请求类型
        if (request.getHeader(HTTP_HEADER) != null) {
            try {
                response.getWriter().println(JsonUtils.toJson(JSONResult.errorMsg("服务器出错了"+exception.getMessage())));
            } catch (IOException e) {
                logger.error("服务器失败时发送错误提示信息失败", e);
            }
            //返回一个空的ModelAndView表示已经手动生成响应
            //return null表示使用默认的处理方式，等于没处理
            return new ModelAndView();
        } else {
            ModelAndView m = new ModelAndView();
            m.addObject("message", exception.getMessage());
            m.setViewName("error/500");
            return m;
        }

    }


}
