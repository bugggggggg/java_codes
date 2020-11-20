package com.codespace.judger;


import com.codespace.judger.data.ExecuteResult;

public interface LocalCommandExecutor {
    ExecuteResult executeCommandOnlyOut(String command);
    ExecuteResult executeCommandInAndOut(String command,int timeout,String filepath);
    ExecuteResult executeCommandInAndOut(String command,String filepath);
}
