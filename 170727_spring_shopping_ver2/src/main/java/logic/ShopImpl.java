package logic;

import java.util.List;

public class ShopImpl implements Shop{
	private ItemCatalog itemCatalog;
	private UserCatalog userCatalog;
	public void setUserCatalog(UserCatalog userCatalog) {
		this.userCatalog = userCatalog;
	}

	public void setItemCatalog(ItemCatalog itemCatalog) {
		this.itemCatalog = itemCatalog;
	}

	@Override
	public List<Item> getItemList() {
		// TODO Auto-generated method stub
		return itemCatalog.getItemList();
	}

	@Override
	public Item getItemByItemId(Integer itemId) {
		// TODO Auto-generated method stub
		return itemCatalog.getItemByItemId(itemId);
	}

	@Override
	public User getUserByUserIdAndPassword(String userId, String password) {
		// TODO Auto-generated method stub
		return userCatalog.getUserByUserIdAndPassword(userId, password);
	}
	

}
