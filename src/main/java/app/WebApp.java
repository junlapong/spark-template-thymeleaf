package app;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import static spark.Spark.get;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Thymeleaf template engine example
 */
public class WebApp implements spark.servlet.SparkApplication {

    private static final Logger log = LoggerFactory.getLogger(WebApp.class);

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

            log.info("User-Agent: {}", request.headers("User-Agent"));

            Map<String, Object> model = new HashMap<>();
            model.put("name", "Jun");
            return new ModelAndView(model, "home"); // located in resources/templates
        }, new ThymeleafTemplateEngine());

    }
}