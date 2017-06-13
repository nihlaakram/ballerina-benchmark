package org.ballerinalang.launcher;

import org.ballerinalang.BLangProgramLoader;
import org.ballerinalang.BLangProgramRunner;
import org.ballerinalang.natives.connectors.BallerinaConnectorManager;
import org.ballerinalang.services.MessageProcessor;
import org.ballerinalang.util.codegen.ProgramFile;
import org.wso2.carbon.messaging.ServerConnector;
import org.wso2.carbon.messaging.exceptions.ServerConnectorException;

import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/*
* Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
public class BProgmRunner {

    private static Path programDirPath = Paths.get(System.getProperty("user.dir"), new String[0]);
    private static PrintStream outStream;
    private static ProgramFile programFile;
    private static List<String> arg;

    BProgmRunner() {
    }

    static void runMain(Path sourceFilePath, List<String> args) {
        programFile = (new BLangProgramLoader()).loadMainProgramFile(programDirPath, sourceFilePath);
        arg = args;
       // Runtime.getRuntime().exit(0);
    }

    public static void runProgram(){
        //BallerinaConnectorManager.getInstance().initializeClientConnectors(new MessageProcessor());
        (new BLangProgramRunner()).runMain(programFile, (String[])arg.toArray(new String[0]));
    }

    static void runServices(Path[] serviceFilePaths) {
        BallerinaConnectorManager.getInstance().initialize(new MessageProcessor());
        Path[] var1 = serviceFilePaths;
        int var2 = serviceFilePaths.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            Path servicePath = var1[var3];
            ProgramFile programFile = (new BLangProgramLoader()).loadServiceProgramFile(programDirPath, servicePath);
            outStream.println("ballerina: deploying service(s) in '" + servicePath + "'");
            (new BLangProgramRunner()).startServices(programFile);
        }

        try {
            List<ServerConnector> startedConnectors = BallerinaConnectorManager.getInstance().startPendingConnectors();
            startedConnectors.forEach((serverConnector) -> {
                outStream.println("ballerina: started server connector " + serverConnector);
            });
        } catch (ServerConnectorException var6) {
            throw new RuntimeException("error starting server connectors: " + var6.getMessage(), var6);
        }
    }

    static {
        outStream = System.out;
    }
}
