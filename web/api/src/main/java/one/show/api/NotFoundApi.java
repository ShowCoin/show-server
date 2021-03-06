package one.show.api;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import one.show.view.Result;

@Controller
public class NotFoundApi extends BaseApi{

    /**
     * 404
     * @return default successful
     *
     */
    @RequestMapping(value = "/404")
    @ResponseBody
    public Result<Map<String, Object>> notFound() {
        return success();
    }
}
