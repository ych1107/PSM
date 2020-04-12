package com.ujiuye.usual.service;

import com.ujiuye.usual.bean.Position;
import com.ujiuye.usual.bean.Task;

import java.util.List;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-12-02 19:27
 **/
public interface TaskService {

    List<Position> getAllPosition();

    boolean saveInfo(Task task);

    List<Task> getAll();

    boolean updateStatus(Task task);

    Task getOne(Integer id);

    int taskStatus();


}
