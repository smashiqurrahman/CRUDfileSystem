package dao;

public interface DAO {

	int add(String id,String name,String age);
	int delete(String removeTerm);
	int update(String editTerm, String newID, String newName, String newAge);
	int search(String searchTerm);

}


