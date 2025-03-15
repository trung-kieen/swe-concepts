package com.n22dccn045.n22dccn045_752_oop;
public class LibraryBook {
    // Thuộc tính
    private String bookID;
    private String title;
    private String author;
    private boolean isBorrowed;

    // Constructor
    public LibraryBook(String bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isBorrowed = false; // Mặc định sách chưa được mượn
    }

    // Getter và Setter
    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    // Phương thức mượn sách (được viết lại theo yêu cầu)
    public void borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("Bạn đã mượn sách: " + title);
        } else {
            System.out.println("Sách đã được mượn!");
        }
    }

    // Phương thức trả sách
    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println("Bạn đã trả sách: " + title);
        } else {
            System.out.println("Sách chưa được mượn, không thể trả!");
        }
    }

    // Phương thức hiển thị thông tin sách
    public void displayInfo() {
        System.out.println("Thông tin sách:");
        System.out.println("Mã sách: " + bookID);
        System.out.println("Tiêu đề: " + title);
        System.out.println("Tác giả: " + author);
        System.out.println("Trạng thái: " + (isBorrowed ? "Đã mượn" : "Có sẵn"));
    }
}
