package dto;

public class ProductDTO {
	private int id;
	private String name;
	private String category;
	private int pricce;
	private String content;
	private int stock;
	public ProductDTO(int id, String name, String category, int pricce, String content, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.pricce = pricce;
		this.content = content;
		this.stock = stock;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPricce() {
		return pricce;
	}
	public void setPricce(int pricce) {
		this.pricce = pricce;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
}
