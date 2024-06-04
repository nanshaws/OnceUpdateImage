package org.example;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("功能如下。");
        System.out.println("1、单纯修改部分前缀，2、根据序列号修改名字");

        int select = scanner.nextInt();
        scanner.nextLine(); // 消耗掉nextInt后的换行符
        if (select == 1) {
            System.out.println("请输入文件夹的名字:");
            String directoryPath = scanner.nextLine(); // 用户输入的文件夹路径

            System.out.println("请输入旧的前缀:");
            String oldPrefix = scanner.nextLine();
            System.out.println("旧的前缀:" + oldPrefix);
            System.out.println("请输入新的前缀:");
            String newPrefix = scanner.nextLine();
            System.out.println("新的前缀:" + newPrefix);
            File dir = new File(directoryPath);

            if (dir.isDirectory()) {
                File[] files = dir.listFiles();
                for (File file : files) {
                    if (file.getName().startsWith(oldPrefix)) {
                        String newName = file.getName().replaceFirst(oldPrefix, newPrefix);
                        File newFile = new File(dir, newName);
                        if (file.renameTo(newFile)) {
                            System.out.println("重命名: " + file.getName() + " -> " + newName);
                        } else {
                            System.out.println("重命名失败: " + file.getName());
                        }
                    }
                }
            } else {
                System.out.println(directoryPath + " 不是一个目录。");
            }
            scanner.close();
        }else if (select==2){
            System.out.println("请输入文件夹的名字:");
            String directoryPath = scanner.nextLine(); // 用户输入的文件夹路径

            System.out.println("请输入要修改的个数:");
            int count = scanner.nextInt();
            scanner.nextLine(); // 添加这行来消耗换行符

            System.out.println("请依次输入要改的序列号:");
            Integer[] s = new Integer[count];
            for (int i = 0; i < count; i++) {
                s[i] = scanner.nextInt();
            }
            scanner.nextLine(); // 添加这行来消耗换行符
            System.out.println("请输入新的名字:");
            String newName = scanner.nextLine();
            String Name=newName;
            System.out.println("新的名字:" + newName);
            File dir = new File(directoryPath);

            if (dir.isDirectory()) {
                File[] files = dir.listFiles();
                for (File file : files) {

                    for (int i=0;i<count;i++){
                        if (s[i]<10){
                            if (file.getName().endsWith("0"+s[i]+".png")){
                                newName=newName+"_"+s[i].toString()+".png";
                                File newFile = new File(dir, newName);
                                if (file.renameTo(newFile)) {
                                System.out.println("重命名: " + file.getName() + " -> " + newName);
                                 newName=Name;
                                 } else {
                                System.out.println("重命名失败: " + file.getName());
                               }
                            }
                        }else {
                            if (file.getName().endsWith(s[i]+".png")){
                                newName=newName+"_"+s[i].toString()+".png";
                                File newFile = new File(dir, newName);
                                if (file.renameTo(newFile)) {
                                    System.out.println("重命名: " + file.getName() + " -> " + newName);
                                    newName=Name;
                                } else {
                                    System.out.println("重命名失败: " + file.getName());
                                }
                            }
                        }

                    }
                }
            } else {
                System.out.println(directoryPath + " 不是一个目录。");
            }
            scanner.close();

        }
    }
}