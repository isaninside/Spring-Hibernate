package id.ac.pcr.springhibernate.web.controller;

import id.ac.pcr.springhibernate.model.Mahasiswa;
import id.ac.pcr.springhibernate.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * Created with IntelliJ IDEA.
 * User: isaninside
 * Date: 4/4/13
 * Time: 1:47 PM
 * To change this template use File | Settings | File Templates.
*/
@Controller
public class MahasiswaController {

    @Autowired
    @Qualifier("mahasiswaService")
    private MahasiswaService mahasiswaService;


    @RequestMapping(value = "/mahasiswa/new", method = RequestMethod.GET)
    public String create(ModelMap modelMap) {
        Mahasiswa mahasiswa = new Mahasiswa();
        modelMap.addAttribute("mhs", mahasiswa);

        return "mahasiswa/create";
    }

    @RequestMapping(value = "/mahasiswa/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        mahasiswaService.delete(id);
        return "redirect:/mahasiswa";
    }

    @RequestMapping(value = "/mahasiswa/{id}/edit", method = RequestMethod.GET)
    public String edit(ModelMap modelMap, @PathVariable("id") Long id) {
        Mahasiswa mahasiswa = mahasiswaService.findMahasiswa(id);
        modelMap.addAttribute("mhs", mahasiswa);


        return "mahasiswa/edit";
    }

    @RequestMapping(value = "/mahasiswa", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("data", mahasiswaService.findMahasiswa());
        return "mahasiswa/index";
    }

    @RequestMapping(value = "/mahasiswa", method = RequestMethod.POST)
    public String save(@ModelAttribute("mhs") Mahasiswa mahasiswa, BindingResult result, ModelMap modelMap) {
        if (mahasiswa == null) throw new IllegalArgumentException("An Object is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("mhs", mahasiswa);

            return "mahasiswa/create";
        }

        mahasiswaService.save(mahasiswa);

        return "redirect:/mahasiswa/" + mahasiswa.getId();
    }

    @RequestMapping(value = "/mahasiswa/{id}", method = RequestMethod.GET)
    public String show(ModelMap modelMap, @PathVariable("id") Long id) {
        Mahasiswa data = mahasiswaService.findMahasiswa(id);
        modelMap.addAttribute("data", data);

        return "mahasiswa/show";
    }

    @RequestMapping(value = "/mahasiswa", method = RequestMethod.PUT)
    public String update(@ModelAttribute("mhs") Mahasiswa mahasiswa, BindingResult result, ModelMap modelMap) {
        if (mahasiswa == null) throw new IllegalArgumentException("A Product is required");
        if (result.hasErrors()) {
            modelMap.addAttribute("mhs", mahasiswa);

            return "mahasiswa/edit";
        }

        mahasiswaService.save(mahasiswa);


        return "redirect:/mahasiswa/" + mahasiswa.getId();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(User.class, new UserEditor(securityService));
    }
}
