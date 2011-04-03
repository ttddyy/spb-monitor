package net.ttddyy.monitor.core.aop.controller;

import net.ttddyy.monitor.core.aop.MethodCallContext;
import net.ttddyy.monitor.core.aop.MethodCallContextRepository;
import net.ttddyy.monitor.core.aop.MethodCallEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author Tadaya Tsuyukubo
 */
@Controller
public class MethodCallTextController {

    private static final String DEFAULT_LINE_SEPARATOR = "#---";

    private MethodCallContextRepository repository;

    private String lineSeparator = DEFAULT_LINE_SEPARATOR;


    @RequestMapping(value = "/text/all")
//    public ResponseEntity<String> getAll(HttpEntity<byte[]> requestEntity, HttpServletResponse response, Writer writer)
    public void getAll(HttpServletResponse response)
            throws Exception {
        final List<MethodCallContext> contexts = repository.getAll();
        Collections.reverse(contexts);

        final StringBuilder sb = new StringBuilder();
        for (MethodCallContext context : contexts) {
            // TODO: format context element
            final List<MethodCallEntry> entries = context.getEntries();
            for (MethodCallEntry entry : entries) {
                sb.append(entry.getMethodName());
                sb.append(System.getProperty("line.separator"));
            }
            sb.append(lineSeparator);
        }

        final String responseBody = sb.toString();

        final HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.TEXT_PLAIN);
//        return new ResponseEntity<String>(responseBody, HttpStatus.CREATED);
//        return new ResponseEntity<String>(responseBody, responseHeaders, HttpStatus.CREATED);

        response.setContentType("text/plain");
        response.setContentLength(responseBody.length());
        response.getOutputStream().write(responseBody.getBytes());
//        PrintWriter out = new PrintWriter(response.getOutputStream());
//        out.print(responseBody);
//        out.flush();
//        out.close();
//        writer.append(responseBody);
//        return response;
    }

    @RequestMapping(value = "/text/dateRange/{from}/{to}")
    public void getByDateRange(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date from,
                               @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to) {

    }


    @Autowired
    public void setRepository(MethodCallContextRepository repository) {
        this.repository = repository;
    }

    public void setLineSeparator(String lineSeparator) {
        this.lineSeparator = lineSeparator;
    }
}
