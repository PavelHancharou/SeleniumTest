package com.gmail.pages;

public enum LinkNames {
	Inbox("Входящие"),
	Starred("Помеченные"),
	Sent("Отправленные"),
	Draft("Черновики"),
	Important("Важные"),
	Chats("Чаты"),
	AllMail("Вся почта"),
	Spam("Спам"),
	Trash("Корзина"),
	Categories("Категории");
	
	private String linkName;
	
	private LinkNames(String name){
		this.linkName = name;
	}

	public String getLinkName() {
		return linkName;
	}
}
