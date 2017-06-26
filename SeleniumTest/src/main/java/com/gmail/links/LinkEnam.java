package com.gmail.links;

public enum LinkEnam {
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
	
	private LinkEnam(String name){
		this.linkName = name;
	}

	public String getLinkName() {
		return linkName;
	}
}
