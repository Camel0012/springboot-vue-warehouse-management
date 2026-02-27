package com.cow.horse.controller;


import com.cow.horse.common.Result;
import com.cow.horse.entity.Menu;
import com.cow.horse.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器：菜单栏模块
 * </p>
 *
 * @author cow.horse
 * @since 2023-01-03
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    /*
     * 根据用户身份获取菜单列表
     * @author cow.horse
     * @date 2023/1/3 20:48
     */
    @GetMapping("/list")
    public Result list(@RequestParam String roleId){
        List list = menuService.lambdaQuery()
                .like(Menu::getMenuright,roleId)
                .list();
        return Result.success(list);
    }
}
