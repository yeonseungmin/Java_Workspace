package p1;

public class App {
    public static void main(String[] args) {
        // 자료구조     ArrayList , HashMap이 제일 중요
        // LinkedList
        MyLinkedList list = new MyLinkedList();
        list.add(new StudentDto("철수"));
        list.add(new StudentDto("영희"));
        list.add(new StudentDto("길동"));
        list.add(new StudentDto("한조"));
        list.add(new StudentDto("멜시"), 2);

        list.remove(3);

        System.out.println(list.get(0).name);
        System.out.println(list.get(1).name);
        System.out.println(list.get(2).name);
        System.out.println(list.get(3).name);
        System.out.println(list.get(4).name);

        
    }
}


class StudentDto{
    StudentDto(String name){
        this.name =name;
    }
    String name;
    int age;
    int score;
}

//======================================================================================//
// 학생 정보를 담을 수 있는 (알고리즘)... 클래스 정의 : LinkedList
// 이미 구현된것을 쓰면 된다.   (장점 단점의 이해)
class Node{
    StudentDto data;
    Node next;
}

class MyLinkedList{
    private Node firstNode;

    //맨뒤에 추가
    public void add(StudentDto data){
        Node newNode = new Node();
        newNode.data = data;
        if(firstNode == null){
            firstNode = newNode;
            return;
        }

        // 꼬리찾기 next;
        Node tempNode = firstNode;
        while(tempNode.next != null){
            tempNode =tempNode.next;    // 핵심 코드
        }
        // 마지막 노드에 새로운 노드 붙이기
        tempNode.next = newNode;
    }

    // 삭제
    public void remove(int index){
        if(index == 0){
            firstNode = firstNode.next;
            return;
        }

        Node tempNode = firstNode;
        for (int i =0; i<index-1 ; i++){
            tempNode = tempNode.next;

        }
        tempNode.next = tempNode.next.next;
    }

    // 삽입 오버로딩
    public void add(StudentDto data, int index){
        Node newNode = new Node();
        newNode.data = data;
        if(index == 0){
            newNode.next = firstNode;
            firstNode = newNode;
            return;
        }
        Node tempNode = firstNode;
        for(int i =0; i<index -1; i++){
            tempNode = tempNode.next;
        }
        newNode.next = tempNode.next;
        tempNode.next = newNode;
    }

    //접근...진짜 최악 
    public StudentDto get(int index){
        if(index == 0){return firstNode.data;}

        Node tempNode = firstNode;
        for(int i = 0; i < index; i++){
            tempNode = tempNode.next;
        }

        return tempNode.data;
    }

}