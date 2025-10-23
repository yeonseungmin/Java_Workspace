package com.accountbook.acb.repository;

import com.accountbook.acb.dto.AccountBookDto;
import com.accountbook.acb.util.IoManager;

public class Repository {
private AccountBookDto[] list = new AccountBookDto[5];
    private int count=0;

    public void save(AccountBookDto accountBookDto){
        list[count] = accountBookDto;
        count++;
    }
    // 목록 
    public AccountBookDto[] findAll(){
        // 깊은 복사
        // 코드 복습시 어려우면 
        // 필요한 만큼 배열 복사해서 리턴한다.
        AccountBookDto[] newList = new AccountBookDto[count];

        for (int i=0; i<count; i++){
            String type = list[i].getType();
            int money = list[i].getMoney();
            String category = list[i].getCategory();
            String note = list[i].getNote();
            String date = list[i].getDate();

            AccountBookDto AccountBookDto = new AccountBookDto(type,money,category,note,date);
            newList[i] = AccountBookDto;
        }
        return newList;
    }
    // 삭제
    public int RemoveAccountBook(String removeDate,int removeMoney){

        int removeCount =0;
        

        for(int i =0; i< count; i++){
            if(list[i].getDate().equals(removeDate) && list[i].getMoney()==removeMoney){
                for(int x = i; x< count-1; x ++){
                    list[x] = list[x+1];

                }
                count --;
                i--;
                removeCount++;
            }
        }
        return removeCount;
    }

    // 카테고리 합
    public int findByCategoryCount(String serchCategory){
        int searchCount =0;
            for(int i =0; i< count; i++){
            if(list[i].getCategory().equals(serchCategory)){
                searchCount ++;
                }
            }   
            return searchCount;
    }

    // 금액 내림차순 보기
    
}
