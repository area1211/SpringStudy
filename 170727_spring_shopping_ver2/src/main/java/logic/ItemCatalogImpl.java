package logic;

import java.util.List;

import dao.ItemDao;

public class ItemCatalogImpl implements ItemCatalog{
	private ItemDao itemDao;
	
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	@Override
	public List<Item> getItemList() {
		return itemDao.findAll();
	}

	@Override
	public Item getItemByItemId(Integer itemId) {
		// TODO Auto-generated method stub
		return itemDao.find(itemId);
	}

}
