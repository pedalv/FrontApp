package no.websphere.listmanager.web.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import no.websphere.listmanager.model.ListItem;
import no.websphere.listmanager.service.ListItemService;
import no.websphere.listmanager.service.impl.ListItemServiceImpl;
import no.websphere.listmanager.web.model.ListItemBean;
import no.websphere.listmanager.web.model.UserBean;

@ManagedBean
@RequestScoped
public class ListItemController {

	private final ListItemService listItemService;
	
	@ManagedProperty("#{userBean}")
	private UserBean userBean;
	
	@ManagedProperty("#{listItemBean}")
	private ListItemBean listItemBean;
	
	public ListItemController() {
		// Use DI
		listItemService = new ListItemServiceImpl();
	}
	
	public String save() {
		if (listItemBean.getId() == null || listItemBean.getId() == 0) {
			listItemService.addListItem(userBean.getUserId(), listItemBean.getValue());
		} else {
			listItemService.updateListItem(userBean.getUserId(), listItemBean.getId(), listItemBean.getValue());
		}
		
		listItemBean.setId(null);
		listItemBean.setValue(null);
		
		//return "list?faces-redirect=true";
		return null; // because use ajax
	}
	
	public String edit(ListItem listItem) {
		listItemBean.setId(listItem.getId());
		listItemBean.setValue(listItem.getValue());
		return null;
	}
	
	public String delete(ListItem listItem) {
		listItemService.deleteListItem(userBean.getUserId(), listItem.getId());
		
		//return "list?faces-redirect=true";
		return null; // because use ajax
	}
	
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	
	public void setListItemBean(ListItemBean listItemBean) {
		this.listItemBean = listItemBean;
	}
}