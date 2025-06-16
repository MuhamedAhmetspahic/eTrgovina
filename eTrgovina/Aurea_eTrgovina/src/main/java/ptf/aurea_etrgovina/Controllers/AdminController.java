package ptf.aurea_etrgovina.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ptf.aurea_etrgovina.Services.ProductService;
import ptf.aurea_etrgovina.Models.Product;

import java.util.List;

@Controller
@RequestMapping("/Admin")
public class AdminController {

    @Autowired
    private ProductService productService;

    @GetMapping("/AdminDashboard")
    public String getProducts(Model model) {
        List<Product> product = productService.getAllProducts();
        model.addAttribute("products", product);
        return "Admin_dashboard";
    }

    /*@GetMapping("/Korisnici")
    public String korisniciPage() {
        return "Korisnici";
    }*/

    @GetMapping("/Proizvodi")
    public String listProducts(Model model) {
        model.addAttribute("product", productService.getAllProducts());
        return "/Proizvodi";
    }

    @GetMapping("/AdminDashboard/product/new")
    public String newProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    @PostMapping("/AdminDashboard/product")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/Admin/Proizvodi";
    }

    @GetMapping("/AdminDashboard/product/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product-form";
    }

    @PostMapping("/AdminDashboard/product/update")
    public String updateProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/Admin/Proizvodi";
    }

    @GetMapping("/AdminDashboard/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/Admin/Proizvodi";
    }
}