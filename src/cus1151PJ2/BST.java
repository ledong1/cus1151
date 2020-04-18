package cus1151PJ2;

/**
 * @author
 *
 */
class BST{
    
    Node root;

    private class Node{
    	
    	String keyword;
        Record record;
        int size;
        Node l;
        Node r;

        private Node(String k){
        	// TODO Instantialize a new Node with keyword k.
        	this.keyword = k;
        	this.record = null;
        	this.size = 0;
        	this.l = null;
        	this.r = null;
        }

        private void update(Record r){
        	//TODO Adds the Record r to the linked list of records. 
        	// You do not have to check if the record is already in the list.
        	//HINT: Add the Record r to the *front* of your linked list.
        	r.next = this.record;
        	this.record = r;
        	this.size+=1;
        }
        
        private void add(String k, Record rec){
        	//add the record to the given node inside the BST
            if(k.compareTo(this.keyword)<0) {
            	if(this.l==null) {
            		this.l=new Node(k);
            	}
            	this.l.add(k,rec);
            }else if(k.compareTo(this.keyword)>0) {
            	if(this.r==null) {
            		this.r=new Node(k);
            	}
            	this.r.add(k,rec);	
            }else {
            	this.update(rec);	
            }                   
        }  
        
//        private boolean check(String k){
//        	//check the keyword in the given node inside the BST
//            if(k.compareTo(this.keyword)<0) {
//            	if(this.l==null) {
//            		return false;
//            	}
//            	this.l.check(k);
//            }else if(k.compareTo(this.keyword)>0) {
//            	if(this.r==null) {
//            		return false;
//            	}
//            	this.r.check(k);	
//            }
//            return true;	             
//        }
        
        private Node find(String k){
        	//find the keyword in the given node inside the BST
        	Node t=new Node(null);
            if(k.compareTo(this.keyword)<0) {
            	if(this.l==null) {
            		return null;
            	}
            	t=this.l.find(k);
            }else if(k.compareTo(this.keyword)>0) {
            	if(this.r==null) {
            		return null;
            	}
            	t=this.r.find(k);	
            }else {
            	t=this;
            }
            return t;
            	             
        }
        
        private Node delete(String k){
        	//delete the keyword in the given node inside the BST
//        	if(this==null) {
//        		return null;
//        	}
            if(k.compareTo(this.keyword)<0) {
//            	if(this.l==null) {
//            		return null;
//            	}
            	this.l=this.l.delete(k);
            }else if(k.compareTo(this.keyword)>0) {
//            	if(this.r==null) {
//            		return null;
//            	}
            	this.r=this.r.delete(k);	
            }else {
            	if(this.l==null) {
            		return this.r;
            	}else if(this.r==null) {
            		return this.l;
            	}            	
            	Node t=this.r.min();
            	this.keyword=t.keyword;
            	this.record=t.record;
            	this.size=t.size;
            	this.r=this.r.delete(keyword);            	
            }            
            return this;	             
        }
        
        
        
        
        private Node min(){
        	//get the main child of the given node inside the BST then 
        	Node min=this;
        	while (min.l!=null) {
        		min=min.l;
        	}
//        	Node t=new Node(null);
//        	t=min;
//        	min=null;
        	return min;
        }
        
        
        
    }

    public BST(){
        this.root = null;
    }
    
    
    
    public void insert(String keyword, FileData fd){
        Record recordToAdd = new Record(fd.id, fd.title, fd.author, null);
        //TODO Write a recursive insertion that adds recordToAdd 
        // to the list of records for the node associated with keyword.
        // If there is no node, this code should add the node.
        if(this.root==null){
        	this.root=new Node(keyword);
        	this.root.update(recordToAdd);
        }else {
        	this.root.add(keyword, recordToAdd);
        }
        
    }
	
    
    
    public boolean contains(String keyword){
    	//TODO Write a recursive function which returns true 
    	// if a particular keyword exists in the BST
    	if(this.root==null){
    		return false;
    	}else {
    		return this.root.find(keyword)!=null;
    	}
    	
    }

	public Record get_records(String keyword){
        //TODO Returns the first record for a particular keyword. 
    	// This record will link to other records
    	// If the keyword is not in the BST, it should return null.
		if (this.contains(keyword)){
			return this.root.find(keyword).record;
		}else {
			return null;
		}
    }

    public void delete(String keyword){
    	//TODO Write a recursive function which removes the Node with keyword 
    	// from the binary search tree.
    	// You may not use lazy deletion and if the keyword is not in the BST, 
    	// the function should do nothing.
    	if (this.contains(keyword)){
			Node temp = this.root.delete(keyword);			
    	}    	
    }

    public void print(){
        print(root);
    }

    private void print(Node t){
        if (t != null){
            print(t.l);
            System.out.println(t.keyword);
            Record r = t.record;
            while(r != null){
            	System.out.println("\t" + r.title);
                r = r.next;
            }
            print(t.r);
        } 
    }
}
