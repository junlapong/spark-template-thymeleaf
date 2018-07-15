package app;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import static spark.Spark.get;

/**
 * Thymeleaf template engine example
 */
public class WebApp implements spark.servlet.SparkApplication {

    @Override
    public void init() {

        // hello.html file is in resources/templates directory
        get("/hello", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("message", "Hello Thymeleaf!");
            return new ModelAndView(model, "hello"); // located in resources/templates
        }, new ThymeleafTemplateEngine());


        // hello.html file is in resources/templates directory
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("name", "Jun");
            return new ModelAndView(model, "home"); // located in resources/templates
        }, new ThymeleafTemplateEngine());

    }
}