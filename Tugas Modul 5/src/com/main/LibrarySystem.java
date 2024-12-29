package com.main;

import Books.*;
import Data.Admin;
import Data.Student;
import java.util.ArrayList;
import java.util.Scanner;
import exception.custom.IllegalAdminAccessException;

public class LibrarySystem {

    public static ArrayList<Book> daftarBuku = new ArrayList<>();
    public static ArrayList<Student> studentList = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Menambahkan buku dan mahasiswa ke dalam daftar
        // Inisialisasi buku
        daftarBuku.add(new StoryBooks("SB1", "The Adventures of Sherlock Holmes", 10, "Mystery", "Arthur Conan Doyle"));
        daftarBuku.add(new HistoryBooks("HB1", "Sapiens: A Brief History of Humankind", 5, "History", "Yuval Noah Harari"));
        daftarBuku.add(new TextBooks("TB1", "Introduction to Algorithms", 7, "Computer Science", "Thomas H. Cormen"));

        // Inisialisasi mahasiswa
        studentList.add(new Student("202310370311001", "John Doe", "Engineering", "Computer Science") {
            @Override
            public void choiceBook(Book[] bookList) {

            }
        });
        studentList.add(new Student( "202310370311002", "Jane Doe", "Business", "Finance") {
            @Override
            public void choiceBook(Book[] bookList) {

            }
        });
        studentList.add(new Student("202310370311003", "Alice Smith", "Arts", "English Literature") {
            @Override
            public void choiceBook(Book[] bookList) {

            }
        });    boolean isRunning = true;
        while (isRunning) {
            try {
                System.out.println("===== Library System =====");
                System.out.println("1. Login sebagai Mahasiswa");
                System.out.println("2. Login sebagai Admin");
                System.out.println("3. Keluar");
                System.out.print("Pilih antara (1-3): ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // Login sebagai Mahasiswa
                        System.out.print("Masukkan NIM : ");
                        String nimStudent = scanner.next();
                        scanner.nextLine();
                        while (true) {
                            if (nimStudent.length() != 15) {
                                System.out.print("Nim Harus 15 Digit!!!\n");
                                System.out.print("Masukkan NIM : ");
                                nimStudent = scanner.nextLine();
                            } else if (checkNim(nimStudent)) {
                                Student student = new Student(nimStudent) {
                                    @Override
                                    public void choiceBook(Book[] bookList) {

                                    }
                                };
                                student.login();
                                break;
                            } else {
                                System.out.println("Nim tidak terdaftar!");
                                break;
                            }
                        }
                        break;
                    case 2:
                        // Login sebagai Admin
                        Admin admin = new Admin();
                        admin.login();
                        break;
                    case 3:
                        System.out.println("Terima kasih semoga puas dengan pelayanan kami");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } catch (IllegalAdminAccessException e) {
                System.out.println("Terjadi kesalahan akses admin: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static boolean checkNim(String nim) {
        for (Student student : studentList) {
            if (student.getNim().equals(nim)) {
                return true;
            }
        }
        return false;
    }
}