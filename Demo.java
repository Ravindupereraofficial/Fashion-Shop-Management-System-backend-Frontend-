import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class Customer{

	private String orderid;
	private String customerid;
	private String tsize;
	private int qty;
	private double amount;
	private int status;
	
	Customer(String orderid,String customerid,String tsize,int qty,double amount,int status){
		this.orderid=orderid;
		this.customerid=customerid;
		this.tsize=tsize;
		this.qty=qty;
		this.amount=amount;
		this.status=status;
		
		}
	public String getorderid(){
		return orderid;
		}
	
	public String getcustomerid(){
		return customerid;
		}
		
	
	public String getqty(){
		return String.valueOf(qty);
		}
		
	
	public String getamount(){
		
		return String.valueOf(amount);
		
		}
		
	
	public String getstatus(){
		
		return (status==0 ? "Processing" : status==1 ? "DELIVERING" : status==2 ? "DELIVERED" : "NOT VALID STATUS");
		}
	
	public String gettsize(){
		return tsize;
		}	
		
		
	public int getqtyy(){
		return qty;
		}
		
	
	public double getamountt(){
		
		return amount;
		
		}
	public void setstatus(int status){
		
		this.status=status;
		
		}		
	
	
	}


class CustomerCollection{
	
    Customer[] customermainarray;
	private String[] tsizeshop={"XS","S","M","L","XL","XXL"};
	private int z=1;
	private int PROCESSING=0;
	private int DELIVERING=1;
	private int DELIVERED=2;
	
	CustomerCollection(){
		
		customermainarray=new Customer[0];
		
		
			}
			
	public void addCustomer(Customer customer){
		
		extendArray();
		customermainarray[customermainarray.length-1]=customer;
		
		
		}
		
	public void extendArray(){
		
		Customer[] tempcustomerarray=new Customer[customermainarray.length+1];
		
		for(int i=0;i<customermainarray.length;i++){
			tempcustomerarray[i]=customermainarray[i];
			}
		
		customermainarray=tempcustomerarray;	
		
		
		}		
			
			
			
			
	public String genarateorderid(){
		
		String ord="ODR#" + String.format("%06d", z);
		return ord;
		
		}
		
	public void pluseorderid(){
		z++;
		}	
		
	
	
	public String phoneNumberValidate(String phoneNumber){
		
		if(phoneNumber.length()==10 && phoneNumber.charAt(0)=='0'){
			return phoneNumber;
			}else{
				return "not";
				}	
	}
	
	
	public String size(String tsizee){	
		
		
		for(int i=0;i<tsizeshop.length;i++){
			
			if(tsizee.equals(tsizeshop[i])){
				return tsizee;
				}
			}
		return "not";
		}
	
	
	public double getamount(String size,int qty){
		int amount=0;
        switch (size)
	   {
		case "XS": 
			amount=qty*600;
			break;
		case "S":
			amount=qty*800;
			break;
		case "M":
			amount=qty*900;
			break;
		case "L":
			amount=qty*1000;
			break;
		case "XL":
			amount=qty*1100;
			break;
		case "XXL":
			amount=qty*1200;
			break;
	   }
	   return amount;
		
		}
	
	public int status(){
		
		return PROCESSING;
		
		}
		
		
	public void print(){
		
		for(int i=0;i<customermainarray.length;i++){
			
			System.out.println(customermainarray[i].getorderid());
			System.out.println(customermainarray[i].getcustomerid());
			System.out.println(customermainarray[i].getqty());
			System.out.println(customermainarray[i].gettsize());
			System.out.println(customermainarray[i].getamount());
			System.out.println(customermainarray[i].getstatus());
			
			}
		
		}
		
		
		public Customer searchCustomer(String id){
		
		for(int i=0;i<customermainarray.length;i++){
			if(customermainarray[i].getorderid().equalsIgnoreCase(id)){
				
				return customermainarray[i];
				
				}
			
			}
			
			return null;
		
		}
		
		
	public boolean deleteCustomer(String id){
		
		int index=-1;
		
		for (int i = 0; i < customermainarray.length; i++){
			if(customermainarray[i].getorderid().equalsIgnoreCase(id)){
				index=i;
				break;
			}
		}
		if(index==-1){
			return false;
		}else{
			for (int i = index; i < customermainarray.length-1; i++){
				customermainarray[i]=customermainarray[i+1];
			}
				Customer[] tempCustomerArray=new Customer[customermainarray.length-1];
			for (int i = 0; i < tempCustomerArray.length; i++){
				tempCustomerArray[i]=customermainarray[i];
			}
			customermainarray=tempCustomerArray;
			return true;	
		}
	}
		
	public Customer[] getCustomerObjects(){
		
		Customer[] tempcustomer=new Customer[customermainarray.length];
		
		for(int i=0;i<customermainarray.length;i++){
			
			tempcustomer[i]=customermainarray[i];
			}
		return tempcustomer;
		}
		
		
	public boolean setstatuss(Customer customer){
		
		
		customer.setstatus(DELIVERING);
		return true;
		
		
		}
		
	public boolean setstatusss(Customer customer){
		
		
		customer.setstatus(DELIVERED);
		return true;
		
		
		}
		
		
	}

class PlaceOrder extends JFrame{
	
	private CustomerCollection customercollection;
	private JButton back;
	private JButton place;
	
	private JLabel orderid;
	private JLabel customerid;
	private JLabel size;
	private JLabel qty;
	private JLabel amount;
	
	private JLabel orderiddisplay;
	private JLabel amountdisplay;
	private JLabel tsizes;
	
	private JTextField customeridd;
	private JTextField sizee;
	private JTextField qtyy;
	
	PlaceOrder(CustomerCollection customercollection){
		this.customercollection=customercollection;
		
		setSize(500,400);
		setTitle("Place Order");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel backbutton=new JPanel();
		backbutton.setLayout(new FlowLayout(FlowLayout.LEFT));
		back=new JButton("Back");
		back.setBackground(new Color(240,128,128));
		back.setForeground(Color.WHITE);
		back.setFont(new Font("",1,15));
		backbutton.add(back);
		add("North",backbutton);
		
		
		
		JPanel orderidgrid=new JPanel();
		orderidgrid.setLayout(new GridLayout(5,5,2,2));
		
		orderid=new JLabel("     Order ID :  ");
		orderid.setFont(new Font("",1,12));
		
		customerid=new JLabel("     Customer ID :  ");
		customerid.setFont(new Font("",1,12));
		
		size=new JLabel("    Size : ");
		size.setFont(new Font("",1,12));
		
		qty=new JLabel("     Qty :  ");
		qty.setFont(new Font("",1,12));
		
		amount=new JLabel("    Amount : ");
		amount.setFont(new Font("",1,12));
		
		orderiddisplay=new JLabel("    ODR#000001");
		orderiddisplay.setFont(new Font("",1,12));
		
		JPanel customeriddd=new JPanel();
		customeriddd.setLayout(new FlowLayout(FlowLayout.LEFT));
		customeridd=new JTextField(10);
		customeridd.setFont(new Font("",1,20));
		customeriddd.add(customeridd);

		
		JPanel sizeee=new JPanel();
		sizeee.setLayout(new FlowLayout(FlowLayout.LEFT));
		sizee=new JTextField(10);
		sizee.setFont(new Font("",1,20));
		sizeee.add(sizee);
		
		JPanel qtyyy=new JPanel();
		qtyyy.setLayout(new FlowLayout(FlowLayout.LEFT));
		qtyy=new JTextField(10);
		qtyy.setFont(new Font("",1,20));
		qtyyy.add(qtyy);
		
		
		amountdisplay=new JLabel("0");
		amountdisplay.setFont(new Font("",1,12));
		
		orderidgrid.add(orderid);
		orderidgrid.add(orderiddisplay);
		orderidgrid.add(customerid);
		orderidgrid.add(customeriddd);
		orderidgrid.add(size);
		orderidgrid.add(sizeee);
		orderidgrid.add(qty);
		orderidgrid.add(qtyyy);
		orderidgrid.add(amount);
		orderidgrid.add(amountdisplay);
		
		add("Center",orderidgrid);
		
		tsizes=new JLabel("(XS/S/M/L/XL/XXL)");
		tsizes.setFont(new Font("",1,12));
		add("East",tsizes);
		
		JPanel placebutton=new JPanel();
		placebutton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		place=new JButton("Place");
		place.setBackground(new Color(0,206,209));
		place.setForeground(Color.WHITE);
		place.setFont(new Font("",1,15));
		placebutton.add(place);
		add("South",placebutton);
		
		place.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent evt){
				
				String orderid=customercollection.genarateorderid();//fortherobject
				
				String customerid=customeridd.getText();
				String Realcustomerid=customercollection.phoneNumberValidate(customerid);//fortherobject
				if(Realcustomerid.equals("not")){
					
					JOptionPane.showMessageDialog(null,"Invalid Customer Id !! Enter Agin !!!");
					customeridd.setText("");
					return;
					}
				
				
				
				String tsize=sizee.getText().toUpperCase();
				String realtsize=customercollection.size(tsize);
				if(realtsize.equals("not")){
					
					JOptionPane.showMessageDialog(null,"Invalid T-size!! Enter Agin !!!");
					sizee.setText("");
					return;
					}
				
				
				int qty=Integer.parseInt(qtyy.getText());
				
				double amount=customercollection.getamount(realtsize,qty);
				
				amountdisplay.setText(String.valueOf(amount));
				
				int status=customercollection.status();
				
				Customer c1=new Customer(orderid,Realcustomerid,realtsize,qty,amount,status);
				
				customercollection.addCustomer(c1);
				
				JOptionPane.showMessageDialog(null,"Customer Added !!!!!!");
				customercollection.pluseorderid();
				orderiddisplay.setText("    "+customercollection.genarateorderid());
				
				customeridd.setText("");
				sizee.setText("");
				qtyy.setText("");
				amountdisplay.setText("");
				customercollection.print();
				}
				
			});
		
		
		}
	
	
	
	
	}


class DeleteOrder extends JFrame{
	
	private CustomerCollection customercollection;
	private JButton back;
	private JButton delete;
	private JButton search;
	
	private JLabel orderid;
	private JLabel customerid;
	private JLabel size;
	private JLabel qty;
	private JLabel amount;
	private JLabel status;
	
	private JLabel customeriddisplay;
	private JLabel sizedisplay;
	private JLabel qtydisplay;
	private JLabel amountdisplay;
	private JLabel statusdisplay;
	private JButton no;
	
	
	private JTextField orderiddisplay;

	
	DeleteOrder(CustomerCollection customercollection){
		this.customercollection=customercollection;
		
		setSize(500,400);
		setTitle("Delete Order");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel backbutton=new JPanel();
		backbutton.setLayout(new FlowLayout(FlowLayout.LEFT));
		back=new JButton("Back");
		back.setBackground(new Color(240,128,128));
		back.setForeground(Color.WHITE);
		back.setFont(new Font("",1,15));
		backbutton.add(back);
		add("North",backbutton);
		
		
		
		
		
		
		
		JPanel orderidgrid=new JPanel();
		orderidgrid.setLayout(new GridLayout(6,6,2,2));
		
		orderid=new JLabel("     Order ID :  ");
		orderid.setFont(new Font("",1,12));
		
		customerid=new JLabel("     Customer ID :  ");
		customerid.setFont(new Font("",1,12));
		
		size=new JLabel("    Size : ");
		size.setFont(new Font("",1,12));
		
		qty=new JLabel("     Qty :  ");
		qty.setFont(new Font("",1,12));
		
		amount=new JLabel("    Amount : ");
		amount.setFont(new Font("",1,12));
		
		status=new JLabel("    Status : ");
		status.setFont(new Font("",1,12));
		
		JPanel serchbuttonandtextfeild=new JPanel();
		serchbuttonandtextfeild.setLayout(new GridLayout(1,2,2,2));
		
		JPanel orderiddisplayy=new JPanel();
		orderiddisplayy.setLayout(new FlowLayout(FlowLayout.LEFT));
		orderiddisplay=new JTextField(10);
		orderiddisplay.setFont(new Font("",1,12));
		orderiddisplayy.add(orderiddisplay);
		serchbuttonandtextfeild.add(orderiddisplayy);
		
		JPanel searchbutton=new JPanel();
		searchbutton.setLayout(new FlowLayout(FlowLayout.LEFT));
		search=new JButton("Search");
		search.setBackground(new Color(30,144,255));
		search.setForeground(Color.WHITE);
		search.setFont(new Font("",1,13));
		searchbutton.add(search);
		serchbuttonandtextfeild.add(searchbutton);

		customeriddisplay=new JLabel("");
		customeriddisplay.setFont(new Font("",1,12));
		
		sizedisplay=new JLabel("");
		sizedisplay.setFont(new Font("",1,12));
		
		qtydisplay=new JLabel("");
		qtydisplay.setFont(new Font("",1,12));
		
		amountdisplay=new JLabel("");
		amountdisplay.setFont(new Font("",1,12));
		
		statusdisplay=new JLabel("");
		statusdisplay.setFont(new Font("",1,12));
		
		
		
		orderidgrid.add(orderid);
		orderidgrid.add(serchbuttonandtextfeild);
		orderidgrid.add(customerid);
		orderidgrid.add(customeriddisplay);
		orderidgrid.add(size);
		orderidgrid.add(sizedisplay);
		orderidgrid.add(qty);
		orderidgrid.add(qtydisplay);
		orderidgrid.add(amount);
		orderidgrid.add(amountdisplay);
		orderidgrid.add(status);
		orderidgrid.add(statusdisplay);
		
		add("Center",orderidgrid);
		
		
		JPanel placebutton=new JPanel();
		placebutton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		delete=new JButton("Delete");
		delete.setBackground(new Color(205,133,63));
		delete.setForeground(Color.WHITE);
		delete.setFont(new Font("",1,15));
		placebutton.add(delete);
		add("South",placebutton);
		
		search.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent evt){
				
				Customer c1=customercollection.searchCustomer(orderiddisplay.getText());
				
				if(c1!=null){
					
					customeriddisplay.setText(c1.getcustomerid());
					sizedisplay.setText(c1.gettsize());
					qtydisplay.setText(c1.getqty());
					amountdisplay.setText(c1.getamount());
					statusdisplay.setText(c1.getstatus());
					
					
					
					
					}else{
						
						JOptionPane.showMessageDialog(null,"Customer not found...");
				
						}
					
				
				
				
				}
				
			});
		
		
		
		delete.addActionListener(new ActionListener(){
			
			
			
			public void actionPerformed(ActionEvent evt){
				
				Customer c1=customercollection.searchCustomer(orderiddisplay.getText());
				if(c1==null){
					JOptionPane.showMessageDialog(null,"Customer not found...");
					}else{
				
				JFrame deleteconformation=new JFrame();
				deleteconformation.setVisible(true);
				deleteconformation.setSize(200,100);
				deleteconformation.setTitle("Delete Conformation");
				deleteconformation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				deleteconformation.setLocationRelativeTo(null);
			
				
				JPanel textin=new JPanel();
				textin.setLayout(new FlowLayout(FlowLayout.CENTER));
				JLabel text=new JLabel("Do you want to delete this Order ? ");
				text.setFont(new Font("",0,10));
				textin.add(text);
				deleteconformation.add("North",textin);
				
				JPanel buttons=new JPanel();
				buttons.setLayout(new GridLayout(1,2));
				JPanel buttonyes=new JPanel();
				buttonyes.setLayout(new FlowLayout(FlowLayout.CENTER));
				JButton yes=new JButton("Yes");
				JPanel buttonno=new JPanel();
				buttonno.setLayout(new FlowLayout(FlowLayout.CENTER));
				no=new JButton("No");
				buttonno.add(no);
				buttonyes.add(yes);
				buttons.add(buttonyes);
				buttons.add(buttonno);
				deleteconformation.add("Center",buttons);
				
				no.addActionListener(new ActionListener(){
			
				public void actionPerformed(ActionEvent evt){	
				deleteconformation.dispose();
				
			
					}
				});
				
				yes.addActionListener(new ActionListener(){
			
					public void actionPerformed(ActionEvent evt){
						
						Customer c1=customercollection.searchCustomer(orderiddisplay.getText());
				
				if(c1!=null){
					
					boolean idDeleted=customercollection.deleteCustomer(orderiddisplay.getText());
						if(idDeleted){
						
						JOptionPane.showMessageDialog(null,"SuccsessFully Deleted");
						
						
						}else{
							
							JOptionPane.showMessageDialog(null,"Customer not found...");
					
							}
					
					
					}else{
						
						JOptionPane.showMessageDialog(null,"Customer not found...");
						
				
						}	
				
				}
				
				
				});
				
				
				
				}
				}
				
			});
			
			
		
		}
	
	
	
	
	}
	
class SearchOrder extends JFrame{
	
	private CustomerCollection customercollection;
	private JButton back;
	private JButton search;
	
	private JLabel orderid;
	private JLabel customerid;
	private JLabel size;
	private JLabel qty;
	private JLabel amount;
	private JLabel status;
	
	private JLabel customeriddisplay;
	private JLabel sizedisplay;
	private JLabel qtydisplay;
	private JLabel amountdisplay;
	private JLabel statusdisplay;
	
	
	private JTextField orderiddisplay;

	
	SearchOrder(CustomerCollection customercollection){
		this.customercollection=customercollection;
		
		setSize(500,400);
		setTitle("Search Order");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel backbutton=new JPanel();
		backbutton.setLayout(new FlowLayout(FlowLayout.LEFT));
		back=new JButton("Back");
		back.setBackground(new Color(240,128,128));
		back.setForeground(Color.WHITE);
		back.setFont(new Font("",1,15));
		backbutton.add(back);
		add("North",backbutton);
		
		
		JPanel orderidgrid=new JPanel();
		orderidgrid.setLayout(new GridLayout(6,6,2,2));
		
		orderid=new JLabel("     Enter Order ID :  ");
		orderid.setFont(new Font("",1,12));
		
		customerid=new JLabel("     Customer ID :  ");
		customerid.setFont(new Font("",1,12));
		
		size=new JLabel("    Size : ");
		size.setFont(new Font("",1,12));
		
		qty=new JLabel("     Qty :  ");
		qty.setFont(new Font("",1,12));
		
		amount=new JLabel("    Amount : ");
		amount.setFont(new Font("",1,12));
		
		status=new JLabel("    Status : ");
		status.setFont(new Font("",1,12));
		
		JPanel serchbuttonandtextfeild=new JPanel();
		serchbuttonandtextfeild.setLayout(new GridLayout(1,2,2,2));
		
		JPanel orderiddisplayy=new JPanel();
		orderiddisplayy.setLayout(new FlowLayout(FlowLayout.LEFT));
		orderiddisplay=new JTextField(10);
		orderiddisplay.setFont(new Font("",1,12));
		orderiddisplayy.add(orderiddisplay);
		serchbuttonandtextfeild.add(orderiddisplayy);
		
		JPanel searchbutton=new JPanel();
		searchbutton.setLayout(new FlowLayout(FlowLayout.LEFT));
		search=new JButton("Search");
		search.setBackground(new Color(30,144,255));
		search.setForeground(Color.WHITE);
		search.setFont(new Font("",1,13));
		searchbutton.add(search);
		serchbuttonandtextfeild.add(searchbutton);

		customeriddisplay=new JLabel("");
		customeriddisplay.setFont(new Font("",1,12));
		
		sizedisplay=new JLabel("");
		sizedisplay.setFont(new Font("",1,12));
		
		qtydisplay=new JLabel("");
		qtydisplay.setFont(new Font("",1,12));
		
		amountdisplay=new JLabel("");
		amountdisplay.setFont(new Font("",1,12));
		
		statusdisplay=new JLabel("");
		statusdisplay.setFont(new Font("",1,12));
		
		
		
		orderidgrid.add(orderid);
		orderidgrid.add(serchbuttonandtextfeild);
		orderidgrid.add(customerid);
		orderidgrid.add(customeriddisplay);
		orderidgrid.add(size);
		orderidgrid.add(sizedisplay);
		orderidgrid.add(qty);
		orderidgrid.add(qtydisplay);
		orderidgrid.add(amount);
		orderidgrid.add(amountdisplay);
		orderidgrid.add(status);
		orderidgrid.add(statusdisplay);
		
		add("Center",orderidgrid);
		
		
		search.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent evt){
				
				Customer c1=customercollection.searchCustomer(orderiddisplay.getText());
				
				if(c1!=null){
					
					customeriddisplay.setText(c1.getcustomerid());
					sizedisplay.setText(c1.gettsize());
					qtydisplay.setText(c1.getqty());
					amountdisplay.setText(c1.getamount());
					statusdisplay.setText(c1.getstatus());
					
					
					
					
					}else{
						
						JOptionPane.showMessageDialog(null,"Customer not found...");
				
						}
					
				
				
				
				}
				
			});
		
		
		}
		
	}
	
class SearchCustomer extends JFrame{
	private CustomerCollection customercollection;
	private JButton back;
	private JButton search;
	private JLabel customerid;
	private JLabel total;
	private JLabel totaldisplay;
	
	private JTextField customeriddisplay;
	
	
	
	private JTable cusreport;
	private DefaultTableModel dtm;

	
	SearchCustomer(CustomerCollection customercollection){
		this.customercollection=customercollection;
		
		setSize(500,400);
		setTitle("Search Customer");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel backbutton=new JPanel();
		backbutton.setLayout(new FlowLayout(FlowLayout.LEFT));
		back=new JButton("Back");
		back.setBackground(new Color(240,128,128));
		back.setForeground(Color.WHITE);
		back.setFont(new Font("",1,15));
		backbutton.add(back);
		add("North",backbutton);
		
		JPanel center=new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));//fromchatgptttt
	
		JPanel firstrow=new JPanel();
		firstrow.setLayout(new GridLayout(1,3,2,2));
		
		JPanel customeridshow=new JPanel();
		customeridshow.setLayout(new FlowLayout(FlowLayout.LEFT));
		customerid=new JLabel("   Enter Customer ID : ");
		customerid.setFont(new Font("",1,12));
		customeridshow.add(customerid);
		
		JPanel customeriddisplaypanel=new JPanel();
		customeriddisplaypanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		customeriddisplay=new JTextField(10);
		customeriddisplay.setFont(new Font("",1,12));
		customeriddisplaypanel.add(customeriddisplay);
		
		JPanel searchbutton=new JPanel();
		searchbutton.setLayout(new FlowLayout(FlowLayout.LEFT));
		search=new JButton("Search");
		search.setBackground(new Color(30,144,255));
		search.setForeground(Color.WHITE);
		search.setFont(new Font("",1,13));
		searchbutton.add(search);
		
		firstrow.add(customeridshow);
		firstrow.add(customeriddisplaypanel);
		firstrow.add(searchbutton);
	
	
		center.add("North",firstrow);
		
		JPanel table=new JPanel();
		table.setLayout(new FlowLayout(FlowLayout.CENTER));
		String[] columnnames={"Size","Qty","Amount"};	
		dtm=new DefaultTableModel(columnnames,0);
		cusreport=new JTable(dtm);
		JScrollPane tablepane=new JScrollPane(cusreport);
		table.add(tablepane);
		
		center.add("Center",table);
		
		add("Center",center);
		
		
		
		JPanel down=new JPanel();
		down.setLayout(new GridLayout(1,2,2,2));
		
		JPanel totall=new JPanel();
		totall.setLayout(new FlowLayout(FlowLayout.CENTER));
		total=new JLabel("Total :");
		total.setFont(new Font("",0,12));
		totall.add(total);
		
		JPanel totaldisplayy=new JPanel();
		totaldisplayy.setLayout(new FlowLayout(FlowLayout.CENTER));
		totaldisplay=new JLabel("0.00");
		totaldisplay.setFont(new Font("",0,12));
		totaldisplayy.add(totaldisplay);
		
		down.add(totall);
		down.add(totaldisplayy);
		
		add("South",down);
		
		search.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent evt){
				
				
				
				
			}
		
			});
		
	
		}
	
	}
	
class ChangeStatus extends JFrame{
	
	private CustomerCollection customercollection;
	private JButton back;
	private JButton delete;
	private JButton search;
	
	private JLabel orderid;
	private JLabel customerid;
	private JLabel size;
	private JLabel qty;
	private JLabel amount;
	private JLabel status;
	
	private JLabel customeriddisplay;
	private JLabel sizedisplay;
	private JLabel qtydisplay;
	private JLabel amountdisplay;
	private JLabel statusdisplay;
	private JButton DELIVERED;
	
	
	private JTextField orderiddisplay;

	
	ChangeStatus(CustomerCollection customercollection){
		this.customercollection=customercollection;
		
		setSize(500,400);
		setTitle("Change Order Status");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel backbutton=new JPanel();
		backbutton.setLayout(new FlowLayout(FlowLayout.LEFT));
		back=new JButton("Back");
		back.setBackground(new Color(240,128,128));
		back.setForeground(Color.WHITE);
		back.setFont(new Font("",1,15));
		backbutton.add(back);
		add("North",backbutton);
		
		
		JPanel orderidgrid=new JPanel();
		orderidgrid.setLayout(new GridLayout(6,6,2,2));
		
		orderid=new JLabel("     Order ID :  ");
		orderid.setFont(new Font("",1,12));
		
		customerid=new JLabel("     Customer ID :  ");
		customerid.setFont(new Font("",1,12));
		
		size=new JLabel("    Size : ");
		size.setFont(new Font("",1,12));
		
		qty=new JLabel("     Qty :  ");
		qty.setFont(new Font("",1,12));
		
		amount=new JLabel("    Amount : ");
		amount.setFont(new Font("",1,12));
		
		status=new JLabel("    Status : ");
		status.setFont(new Font("",1,12));
		
		JPanel serchbuttonandtextfeild=new JPanel();
		serchbuttonandtextfeild.setLayout(new GridLayout(1,2,2,2));
		
		JPanel orderiddisplayy=new JPanel();
		orderiddisplayy.setLayout(new FlowLayout(FlowLayout.LEFT));
		orderiddisplay=new JTextField(10);
		orderiddisplay.setFont(new Font("",1,12));
		orderiddisplayy.add(orderiddisplay);
		serchbuttonandtextfeild.add(orderiddisplayy);
		
		JPanel searchbutton=new JPanel();
		searchbutton.setLayout(new FlowLayout(FlowLayout.LEFT));
		search=new JButton("Search");
		search.setBackground(new Color(30,144,255));
		search.setForeground(Color.WHITE);
		search.setFont(new Font("",1,13));
		searchbutton.add(search);
		serchbuttonandtextfeild.add(searchbutton);

		customeriddisplay=new JLabel("");
		customeriddisplay.setFont(new Font("",1,12));
		
		sizedisplay=new JLabel("");
		sizedisplay.setFont(new Font("",1,12));
		
		qtydisplay=new JLabel("");
		qtydisplay.setFont(new Font("",1,12));
		
		amountdisplay=new JLabel("");
		amountdisplay.setFont(new Font("",1,12));
		
		statusdisplay=new JLabel("");
		statusdisplay.setFont(new Font("",1,12));
		
		
		
		orderidgrid.add(orderid);
		orderidgrid.add(serchbuttonandtextfeild);
		orderidgrid.add(customerid);
		orderidgrid.add(customeriddisplay);
		orderidgrid.add(size);
		orderidgrid.add(sizedisplay);
		orderidgrid.add(qty);
		orderidgrid.add(qtydisplay);
		orderidgrid.add(amount);
		orderidgrid.add(amountdisplay);
		orderidgrid.add(status);
		orderidgrid.add(statusdisplay);
		
		add("Center",orderidgrid);
		
		
		JPanel placebutton=new JPanel();
		placebutton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		delete=new JButton("Change Status");
		delete.setBackground(new Color(205,133,63));
		delete.setForeground(Color.WHITE);
		delete.setFont(new Font("",1,15));
		placebutton.add(delete);
		add("South",placebutton);
		
		search.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent evt){
				
				Customer c1=customercollection.searchCustomer(orderiddisplay.getText());
				
				if(c1!=null){
					
					customeriddisplay.setText(c1.getcustomerid());
					sizedisplay.setText(c1.gettsize());
					qtydisplay.setText(c1.getqty());
					amountdisplay.setText(c1.getamount());
					statusdisplay.setText(c1.getstatus());
					
					
					
					
					}else{
						
						JOptionPane.showMessageDialog(null,"Customer not found...");
				
						}
					
				
				
				
				}
				
			});
		
		
		
		delete.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent evt){
				
				
				Customer c1=customercollection.searchCustomer(orderiddisplay.getText());
				if(c1==null){
					JOptionPane.showMessageDialog(null,"Customer not found...");
					return;
				}
				if(c1.getstatus().equals("Processing")){
				
				if(c1==null){
					JOptionPane.showMessageDialog(null,"Customer not found...");
					}else{
				
				JFrame deleteconformation=new JFrame();
				deleteconformation.setVisible(true);
				deleteconformation.setSize(300,100);
				deleteconformation.setTitle("Status");
				deleteconformation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				deleteconformation.setLocationRelativeTo(null);
			
				
				JPanel textin=new JPanel();
				textin.setLayout(new FlowLayout(FlowLayout.CENTER));
				JLabel text=new JLabel("Please Select The Status ");
				text.setFont(new Font("",0,10));
				textin.add(text);
				deleteconformation.add("North",textin);
				
				JPanel buttons=new JPanel();
				buttons.setLayout(new GridLayout(1,2));
				JPanel buttonyes=new JPanel();
				buttonyes.setLayout(new FlowLayout(FlowLayout.CENTER));
				JButton DELIVERING=new JButton("DELIVERING");
				JPanel buttonno=new JPanel();
				buttonno.setLayout(new FlowLayout(FlowLayout.CENTER));
				DELIVERED=new JButton("DELIVERED");
				buttonno.add(DELIVERING);
				buttonyes.add(DELIVERED);
				buttons.add(buttonyes);
				buttons.add(buttonno);
				deleteconformation.add("Center",buttons);
				
				DELIVERED.addActionListener(new ActionListener(){
			
				public void actionPerformed(ActionEvent evt){	
						deleteconformation.dispose();
						
						Customer c1=customercollection.searchCustomer(orderiddisplay.getText());
					
							
							if(c1!=null){
								
								boolean ischanged=customercollection.setstatusss(c1);
								
									if(ischanged){
									
									JOptionPane.showMessageDialog(null,"SuccsessFully Changed");
									
									
									}else{
										
										JOptionPane.showMessageDialog(null,"Customer not found...");
								
										}
								
								
								}else{
									
									JOptionPane.showMessageDialog(null,"Customer not found...");
									
							
									}	
				
			
				}
				});
				
				DELIVERING.addActionListener(new ActionListener(){
			
					public void actionPerformed(ActionEvent evt){
						deleteconformation.dispose();
						Customer c1=customercollection.searchCustomer(orderiddisplay.getText());
							
							if(c1!=null){
								
								boolean ischanged=customercollection.setstatuss(c1);
								
									if(ischanged){
									
									JOptionPane.showMessageDialog(null,"SuccsessFully Changed");
									
									
									}else{
										
										JOptionPane.showMessageDialog(null,"Customer not found...");
								
										}
								
								
								}else{
									
									JOptionPane.showMessageDialog(null,"Customer not found...");
									
							
									}	
				
				}
				
				
				});
				
				
				
				}
				
			}else if(c1.getstatus().equals("DELIVERING")){
				
				
				JFrame deleteconformation=new JFrame();
				deleteconformation.setVisible(true);
				deleteconformation.setSize(300,100);
				deleteconformation.setTitle("Status");
				deleteconformation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				deleteconformation.setLocationRelativeTo(null);
			
				
				JPanel textin=new JPanel();
				textin.setLayout(new FlowLayout(FlowLayout.CENTER));
				JLabel text=new JLabel("Please Select The Status ");
				text.setFont(new Font("",0,10));
				textin.add(text);
				deleteconformation.add("North",textin);
				
				JPanel buttons=new JPanel();
				buttons.setLayout(new GridLayout(1,1));
				JPanel buttonyes=new JPanel();
				buttonyes.setLayout(new FlowLayout(FlowLayout.CENTER));
				DELIVERED=new JButton("DELIVERED");
				buttonyes.add(DELIVERED);
				buttons.add(buttonyes);
				deleteconformation.add("Center",buttons);
				
				DELIVERED.addActionListener(new ActionListener(){
			
				public void actionPerformed(ActionEvent evt){	
						deleteconformation.dispose();
						
						Customer c1=customercollection.searchCustomer(orderiddisplay.getText());
					
							
							if(c1!=null){
								
								boolean ischanged=customercollection.setstatusss(c1);
								
									if(ischanged){
									
									JOptionPane.showMessageDialog(null,"SuccsessFully Changed");
									
									
									}else{
										
										JOptionPane.showMessageDialog(null,"Customer not found...");
								
										}
								
								
								}else{
									
									JOptionPane.showMessageDialog(null,"Customer not found...");
									
							
									}	
				
			
				}
				});
				
				
				
				
				}else if(c1.getstatus().equals("DELIVERED")){
					
					
					JOptionPane.showMessageDialog(null,"Cant Change This Status !!! All Redy Deleverded !");
					
					
					}
		
				}			
			});
			
			
		
		}
	
	
	}
	
class HomePage extends JFrame{
	
	private JLabel fashionshop;
	private JButton search;
	private JButton status;
	private JButton reports;
	private JButton delete;
	private JButton placeorder;
	private JLabel downtext;
	
	HomePage(){
		
		CustomerCollection customercollection=new CustomerCollection();
		setSize(500,400);
		setTitle("Fashion Shop");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		JPanel text=new JPanel();
		text.setLayout(new FlowLayout(FlowLayout.CENTER));
		text.setBackground(new Color(0,206,209)); 
		fashionshop=new JLabel("Fashion Shop");
		fashionshop.setFont(new Font("",1,30));
		fashionshop.setBackground(new Color(0,206,208)); 
		fashionshop.setForeground(Color.WHITE);
		fashionshop.setOpaque(true); 
		text.add(fashionshop);
		add("North",text);
		
		JPanel textt=new JPanel();
		textt.setLayout(new FlowLayout(FlowLayout.CENTER));
		downtext=new JLabel("Copyrights \u00A9 ICET 2024");
		downtext.setFont(new Font("",1,12));
		textt.add(downtext);
		add("South",textt);
		
		
		JPanel westgrid=new JPanel();
		westgrid.setLayout(new GridLayout(5,1,2,2));
		
		JPanel searchh=new JPanel();
		searchh.setLayout(new FlowLayout(FlowLayout.LEFT));
		search=new JButton("Search");
		search.setFont(new Font("",1,18));
		searchh.add(search);
		
		JPanel statuss=new JPanel();
		statuss.setLayout(new FlowLayout(FlowLayout.LEFT));
		status=new JButton("Status");
		status.setFont(new Font("",1,18));
		statuss.add(status);
		
		
		JPanel reportss=new JPanel();
		reportss.setLayout(new FlowLayout(FlowLayout.LEFT));
		reports=new JButton("Reports");
		reports.setFont(new Font("",1,18));
		reportss.add(reports);
		
		
		JPanel deletee=new JPanel();
		deletee.setLayout(new FlowLayout(FlowLayout.LEFT));
		delete=new JButton("Delete");
		delete.setFont(new Font("",1,18));
		deletee.add(delete);
		
		
		JPanel placeorderr=new JPanel();
		placeorderr.setLayout(new FlowLayout(FlowLayout.LEFT));
		placeorder=new JButton("Place Order");
		placeorder.setFont(new Font("",1,23));
		placeorderr.add(placeorder);
		
		westgrid.add(searchh);
		westgrid.add(statuss);
		westgrid.add(reportss);
		westgrid.add(deletee);
		westgrid.add(placeorderr);
		
		add("Center",westgrid);
		
		ImageIcon originalIcon = new ImageIcon("Fashion_Shop.jpg");
		Image scaledImage = originalIcon.getImage().getScaledInstance(200, 255, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(scaledImage);
		JLabel imageLabel = new JLabel(resizedIcon);
		add("East",imageLabel); 
		
		placeorder.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent evt){	
				
				new PlaceOrder(customercollection).setVisible(true);
		
			}
		
			});	
			
			
		delete.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent evt){	
				
				new DeleteOrder(customercollection).setVisible(true);
		
			}
		
			});
			
			
		reports.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent evt){	
				
				new DeleteOrder(customercollection).setVisible(true);
		
			}
		
			});		
			
			
		status.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent evt){	
				
				new ChangeStatus(customercollection).setVisible(true);
		
			}
			
			});
			
			
		search.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent evt){
				
				
				
				
				JFrame deleteconformation=new JFrame();
				deleteconformation.setVisible(true);
				deleteconformation.setSize(400,120);
				deleteconformation.setTitle("Search Option");
				deleteconformation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				deleteconformation.setLocationRelativeTo(null);
				
				JLabel uptext=new JLabel("Please Select The Option");
				deleteconformation.add("North",uptext);
				
				JPanel buttons=new JPanel();
				buttons.setLayout(new GridLayout(1,3,2,2));
				
				JPanel searchCustomerb=new JPanel();
				searchCustomerb.setLayout(new FlowLayout(FlowLayout.CENTER));
				JButton searchCustomer=new JButton("Search Customer");
				searchCustomer.setFont(new Font("",1,10));
				searchCustomerb.add(searchCustomer);
				buttons.add(searchCustomerb);
				
				searchCustomer.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent evt){	
				
				new SearchCustomer(customercollection).setVisible(true);
		
		
			}
			
			});
				
				
				
				JPanel searchOrderb=new JPanel();
				searchOrderb.setLayout(new FlowLayout(FlowLayout.CENTER));
				JButton searchOrder=new JButton("Search Order");
				searchOrder.setFont(new Font("",1,10));
				searchOrderb.add(searchOrder);
				buttons.add(searchOrderb);
				
				searchOrder.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent evt){	
				
				new SearchOrder(customercollection).setVisible(true);
		
			}
			
			});
				
				
				
				JPanel cancelb=new JPanel();
				cancelb.setLayout(new FlowLayout(FlowLayout.CENTER));
				JButton cancel=new JButton("Cancel");
				cancel.setFont(new Font("",1,10));
				cancelb.add(cancel);
				buttons.add(cancelb);
				
				cancel.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent evt){	
				
				deleteconformation.dispose();
		
			}
			
			});
				
				
				
				deleteconformation.add("Center",buttons);
		
			}	
		
			});				
			
			
			
			
			
			
		
		
		}
	
	
	}
	
class Demo{
	
	public static void main(String args[]){
		
		CustomerCollection customercollection=new CustomerCollection();
			
		new HomePage().setVisible(true);
		
		
		}//main method
	
	}
