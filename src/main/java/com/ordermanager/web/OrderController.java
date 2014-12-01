package com.ordermanager.web;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.io.IOUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.ordermanager.domain.Order;
import com.ordermanager.service.OrderService;


@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	 @RequestMapping("/index")
	    public String listContacts(Map<String, Object> map) {

	        map.put("order", new Order());
	        map.put("orderList", orderService.listOrder());

	        return "order";
	    }
	
	@RequestMapping("/")
    public String home() {
			return "redirect:/index";
    }
	 
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addOrder(
            @ModelAttribute("order") Order order,
            @RequestParam(value = "order", required = true) MultipartFile file) {
		
        try {
            Blob blob = Hibernate.createBlob(file.getInputStream());
    	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    	    String t = formatter.format(new Date());
    	    order.setDate(t);
            order.setFilename(file.getOriginalFilename());
            order.setFile(blob);
            order.setType(file.getContentType());
        } catch (IOException e) {
            e.printStackTrace();
        }
         
        try {
            orderService.addOrder(order);
        } catch(Exception e) {
            e.printStackTrace();
        }
         
        return "redirect:/index";
    }

	@RequestMapping("/download/{orderId}")
    public String download(@PathVariable("orderId")
            Integer Id, HttpServletResponse response) {
         
        Order ord = orderService.downloadOrder(Id);
        try {
            response.setHeader("Content-Disposition", "attachment;filename=\"" +ord.getFilename()+ "\"");
            OutputStream out = response.getOutputStream();
            response.setContentType(ord.getType());
            IOUtils.copy(ord.getFile().getBinaryStream(), out);
            out.flush();
            out.close();
         
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return "redirect:/index";
    }

    @RequestMapping("/delete/{orderId}")
    public String removeOrder(@PathVariable("orderId")
    Integer orderId) {
     	orderService.removeOrder(orderId);
     	return "redirect:/index";
    }

}
