package ptf.aurea_etrgovina.Controllers;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ptf.aurea_etrgovina.Models.Product;
import ptf.aurea_etrgovina.Services.ProductService;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String getProducts(Model model) {
        List<Product> product = productService.getAllProducts();
        model.addAttribute("products", product);
        return "Pocetna";
    }

    @GetMapping("/UserDashboard")
    public String getUserDashboard(Model model) {
        List<Product> product = productService.getAllProducts();
        model.addAttribute("products", product);
        return "User_dashboard";
    }
}
