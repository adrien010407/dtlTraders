package net.dandielo.citizens.traders_v3.utils.items.attributes;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.dandielo.citizens.traders_v3.core.exceptions.attributes.AttributeValueNotFoundException;
import net.dandielo.citizens.traders_v3.utils.items.Attribute;
import net.dandielo.citizens.traders_v3.utils.items.ItemAttr;

@Attribute(name="Name", key="n")
public class Name extends ItemAttr {
	private String name;

	public Name(String key)
	{
		super(key);
		name = "";
	}

	public String getName()
	{
		return name;
	}
	
	@Override
	public void onLoad(String data) 
	{
		name = data;
	}

	@Override
	public String onSave() 
	{
		return name;
	}

	@Override
	public void onAssign(ItemStack item)
	{
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
	}

	@Override
	public void onFactorise(ItemStack item) throws AttributeValueNotFoundException 
	{
		if ( !item.hasItemMeta() ) throw new AttributeValueNotFoundException();
		
		ItemMeta meta = item.getItemMeta();
		if ( !meta.hasDisplayName() ) throw new AttributeValueNotFoundException();
		
		name = meta.getDisplayName();
	}
	
	@Override
	public boolean equalsWeak(ItemAttr attr)
	{
		return name.equals(((Name)attr).name);
	}
	
	@Override
	public boolean equalsStrong(ItemAttr attr)
	{
		return name.equals(((Name)attr).name);
	}


}