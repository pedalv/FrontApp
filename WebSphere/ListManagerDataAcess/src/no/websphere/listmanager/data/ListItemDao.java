package no.websphere.listmanager.data;

import java.util.List;

import no.websphere.listmanager.model.ListItem;

public interface ListItemDao {
	
	ListItem getListItemById(Long listItemId);
	
	List<ListItem> getListItemsByUserId(Long userId);
	
	ListItem saveListItem(ListItem listItem);
	
	void deleteListItem(Long listItemId);
	
}
