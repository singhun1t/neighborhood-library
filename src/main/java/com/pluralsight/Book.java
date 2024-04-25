package com.pluralsight;

public class Book {
    private int id;
    private String title;
    private String isbn;
    private boolean isCheckedOut;
    private String checkedOutTo;

    public void checkOut(String name){
        if (!isCheckedOut){
            isCheckedOut = true;
            checkedOutTo = name;
        }else{
            System.out.println("Sorry, book is checked out to: " + name);
        }
    }

    public void checkIn(){
        if (isCheckedOut){
            isCheckedOut = false;
            checkedOutTo = " ";
        }else{
            System.out.println("Book has already been checked.");
        }
    }

    public Book(String title, String isbn, int id ) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    /*public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

     */

}
