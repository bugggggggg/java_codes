package com.codespace.testCompile;

import com.codespace.testCompile.data.ExecuteResult;

public interface LocalCommandExecutor {
    ExecuteResult executeCommandOnlyOut(String command);
    ExecuteResult executeCommandInAndOut(String command,int timeout,String filepath);
    ExecuteResult executeCommandInAndOut(String command,String filepath);
}
