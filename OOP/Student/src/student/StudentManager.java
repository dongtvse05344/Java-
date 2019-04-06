/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

/**
 *
 * @author xhunt
 */
public class StudentManager {
    Student StudentList[] = new Student[50];
    int numOfStudent = 0;
    public void getStudentByIndex(int index){
        if(index <0 || index > numOfStudent)
        {
            System.out.println("Not Found !!!");
            return;
        }
         StudentList[index].ToString();
    }
    
    public int checkID(String ID)
    {
        for (int i =0 ; i < numOfStudent ;i++)
        {
            if (StudentList[i].getID().equals(ID))
            {
                return 1;
            }
        }
        return 0;
    }
    public int addStudent( Student _)
    {
        int existed = findStudent(_.getID());
        if(numOfStudent< StudentList.length && existed == -1)
        {
            StudentList[numOfStudent++] = _;
            return 1;
        }
        else 
        {
            return 0;
        }
    }
    
    public void printStudentList()
    {
        System.out.println("Student list :");
        for(int i = 0 ; i< numOfStudent;i++)
        {
            System.out.println("-------["+i+"]---------");
            StudentList[i].ToString();
        }
    }
    
    public int findStudent(String ID)
    {
        for(int i = 0 ; i< numOfStudent;i++)
        {
            if(StudentList[i].getID().equals(ID))
            {
                return i ;
            }
        }
        return -1;
    }
    
    public void updateStudent(Student _)
    {
        for(int i = 0 ; i< numOfStudent;i++)
        {
            if(StudentList[i].getID().equals(_.getID()))
            {
                StudentList[i] = _;
                return;
            }
        }
        System.out.println("Not found !!!");
    }
    
}
