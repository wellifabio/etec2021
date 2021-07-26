package controllers;

import java.util.ArrayList;

import models.Orcamento;

public class ProcessaOrcamentos {
	
	public static ArrayList<Orcamento> orcamentos = new ArrayList<Orcamento>();
	//public static ArrayList<Integer> indexes = new ArrayList<Integer>();
	
	
	public static Orcamento getMaisBarato()
	{
		if(orcamentos.size() >= 1)
		{
			Orcamento o = orcamentos.get(0);
			int r = 0;
			for(int i = 0; i < orcamentos.size(); i++)
			{
				if(orcamentos.get(i).getPreco() < o.getPreco() && !orcamentos.get(i).ignore)
				{
					o = orcamentos.get(i);
					r = i;
				}
				
			}
			orcamentos.get(r).ignore = true;
			
			return o;
		}else {
			return new Orcamento(0,"","","",0.0);
		}
	}
	
	/*public static int getMaisBaratoIndex()
	{
		if(orcamentos.size() >= 1)
		{
			int r = 0;
			
			for(int i = 0; i < orcamentos.size(); i++)
			{
				if(orcamentos.get(i).getPreco() < orcamentos.get(r).getPreco() && !orcamentos.get(i).ignore)
				{
					r = i;
				}
			}
			orcamentos.get(r).ignore = true;
			
			return r;
		}else {
			return 0;
		}
	}
	
	public static void sort()
	{
		for(int i = 0; i < orcamentos.size(); i++)
		{
			orcamentos.get(i).ignore = false;
		}
		
		if(orcamentos.size() > indexes.size())
		{
			for(int i = 0; i < (orcamentos.size() - indexes.size()); i++)
			{
				indexes.add(0);
			}
		}
		
		for(int i = 0; i < indexes.size(); i++)
		{
			indexes.set(i, getMaisBaratoIndex());
		}
	}*/
	
	public static void sort()
	{
		for(int i = 0; i < orcamentos.size(); i++)
		{
			orcamentos.get(i).ignore = false;
		}
		
		ArrayList<Orcamento> o = new ArrayList<Orcamento>();
		for(int i = 0; i < orcamentos.size(); i++)
		{
			o.add(getMaisBarato());
		}
		
		orcamentos = o;
		
		for(int i = 0; i < orcamentos.size(); i++)
		{
			orcamentos.get(i).ignore = false;
		}
	}
	
}
