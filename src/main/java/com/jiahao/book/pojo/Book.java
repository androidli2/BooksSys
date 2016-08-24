package com.jiahao.book.pojo;

import java.util.Date;

/**
 * Created by Administrator on 2016/8/15.
 */
public class Book {

    private Long bookId;
    private String bookCode;
    private String bookName;
    private Long bookType;
    private String bookAuthor;
    private String publishPress;
    private Date publishDate;
    private Long isBorrow;
    private String createBy;
    private Date creationTime;
    private Date lastUpdatetime;

    private BookType Type;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Long getBookType() {
        return bookType;
    }

    public void setBookType(Long bookType) {
        this.bookType = bookType;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getPublishPress() {
        return publishPress;
    }

    public void setPublishPress(String publishPress) {
        this.publishPress = publishPress;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Long getIsBorrow() {
        return isBorrow;
    }

    public void setIsBorrow(Long isBorrow) {
        this.isBorrow = isBorrow;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getLastUpdatetime() {
        return lastUpdatetime;
    }

    public void setLastUpdatetime(Date lastUpdatetime) {
        this.lastUpdatetime = lastUpdatetime;
    }

    public BookType getType() {
        return Type;
    }

    public void setType(BookType type) {
        Type = type;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Type=" + Type +
                ", lastUpdatetime=" + lastUpdatetime +
                ", creationTime=" + creationTime +
                ", createBy='" + createBy + '\'' +
                ", isBorrow=" + isBorrow +
                ", publishDate=" + publishDate +
                ", publishPress='" + publishPress + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookType=" + bookType +
                ", bookName='" + bookName + '\'' +
                ", bookCode='" + bookCode + '\'' +
                ", bookId=" + bookId +
                '}';
    }
}
