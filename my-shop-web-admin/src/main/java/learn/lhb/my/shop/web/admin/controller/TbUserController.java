package learn.lhb.my.shop.web.admin.controller;

import learn.lhb.my.shop.commons.constant.ConstantUtils;
import learn.lhb.my.shop.commons.dto.BaseResult;
import learn.lhb.my.shop.domain.TbUserDomain;
import learn.lhb.my.shop.web.admin.service.TbUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * 用户管理
 *
 * @author 梁鸿斌
 * @date 2020/2/15.
 * @time 00:35
 */
@Controller
@RequestMapping(value = "user")
public class TbUserController {

    public static final Logger logger = LoggerFactory.getLogger(TbUserController.class);

    @Autowired
    private TbUserService tbUserService;

    /**
     * 跳转到用户列表页
     * @return
     */
    @GetMapping("list")
    public String list(Model model)    {
        List<TbUserDomain> tbUserDomains = tbUserService.selectAll();
        model.addAttribute("tbUserDomains",tbUserDomains);
        // TODO for 和 foreach做个笔记,list里面的遍历也做个笔记
//        for (int i=0;i<tbUserDomains.size();i++)  {
//            logger.debug("id = {}",tbUserDomains.get(i).getId());
//        }
        return "user_list";
    }

    /**
     * 跳转用户表单页（新增编辑操作）
     * @return
     */
    @GetMapping("form")
    public String form()    {
        return "user_form";
    }

    /**
     * 保存用户信息(包括新增和编辑)
     * @param tbUserDomain
     * @param redirectAttributes
     * @return
     */
    @PostMapping("save")
    public String save (TbUserDomain tbUserDomain, Model model, RedirectAttributes redirectAttributes)  {
        BaseResult baseResult = tbUserService.save(tbUserDomain);

        // 保存成功
        if (baseResult.getStatus() == 200)  {
            redirectAttributes.addFlashAttribute(ConstantUtils.BASERESULT,baseResult);
            return "redirect:/user/list";
        }
        // 保存失败
            else {
            model.addAttribute(ConstantUtils.BASERESULT,baseResult);
            return "user_form";
        }


    }
}
