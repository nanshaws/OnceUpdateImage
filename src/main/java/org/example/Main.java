package org.example;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入文件夹的名字:");
        String directoryPath = scanner.nextLine(); // 用户输入的文件夹路径

        System.out.println("请输入旧的前缀:");
        String oldPrefix = scanner.nextLine();
        System.out.println("旧的前缀:"+oldPrefix);
        System.out.println("请输入新的前缀:");
        String newPrefix = scanner.nextLine();
        System.out.println("新的前缀:"+newPrefix);
        File dir = new File(directoryPath);

        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.getName().startsWith(oldPrefix)){
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
    }
}