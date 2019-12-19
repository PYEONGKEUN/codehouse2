package com.itbuddy.codehouse.VO;

import java.util.List;

import com.itbuddy.codehouse.DTO.Article;

public class BoardVO {

	List<Article> articles;
	boolean hasNextPage;
	boolean hasPrevPage;
//	Integer curPage;
	
	
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public boolean isHasNextPage() {
		return hasNextPage;
	}
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	public boolean isHasPrevPage() {
		return hasPrevPage;
	}
	public void setHasPrevPage(boolean hasPrevPage) {
		this.hasPrevPage = hasPrevPage;
	}
//	public Integer getCurPage() {
//		return curPage;
//	}
//	public void setCurPage(int curPage) {
//		this.curPage = curPage;
//	}
//	
	
//	@Override
//	public String toString() {
//		return "BoardVO [articles=" + articles + ", hasNextPage=" + hasNextPage + ", hasPrevPage=" + hasPrevPage
//				+ ", curPage=" + curPage + "]";
//	}
	@Override
	public String toString() {
		return "BoardVO [articles=" + articles + ", hasNextPage=" + hasNextPage + ", hasPrevPage=" + hasPrevPage
				+ "]";
	}
	
	
	
	
}
