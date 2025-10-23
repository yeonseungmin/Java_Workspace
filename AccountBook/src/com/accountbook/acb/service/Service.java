package com.accountbook.acb.service;

import com.accountbook.acb.dto.AccountBookDto;
import com.accountbook.acb.repository.Repository;
import com.accountbook.acb.util.IoManager;

public class Service {
    Repository repository = new Repository();
    public void AccountBookRegister(){
        IoManager.print("--------------가계부  등록 ----------------");
        String type = IoManager.input("타입을 입력해 주세요.(ex 수입/지출) > ");
        int money = Integer.parseInt(IoManager.input("금액 등록 > "));
        String category = IoManager.input("카테고리 입력 (ex: 식비,월급...) > ");
        String note = IoManager.input("메모 입력 > ");
        String date = IoManager.input("날짜 입력(ex: 2025/10/23) > ");

        AccountBookDto accountBookDto = new AccountBookDto(type,money, category, note, date);

        repository.save(accountBookDto);
        IoManager.print("--------------------------------------------");
    }
    public void ListAccountBook(){
        IoManager.print("--------------가계부 등록 목록--------------");
        AccountBookDto[] list = repository.findAll();

        for(AccountBookDto accountBookDto : list){  //list의 크기에 따라 반복 
            String text = "";
            text += " 유형: " + accountBookDto.getType();
            text += ", |금액 : " + accountBookDto.getMoney();
            text += ", |카테고리 : " + accountBookDto.getCategory();
            text += ", |메모 : " + accountBookDto.getNote();
            text += ", |날짜 : " + accountBookDto.getDate();

            IoManager.print(text);
        }

        IoManager.print("총"+ list.length + "의 가계부 기록을 하셨습니다.");
        
        IoManager.print("-----------------------------------------");
    }
    public void DelAccountBook(){
        IoManager.print("----------------가계부 삭제 ----------------");
        ListAccountBook();
        String removeDate = IoManager.input("삭제할 날짜 >" );
        int removeMoney = Integer.parseInt(IoManager.input("삭제할 금액 > "));
        int count =repository.RemoveAccountBook(removeDate,removeMoney);
        
        
        IoManager.print("총" + count + "명의 정보가 삭제되었습니다.");

        IoManager.print("-----------------------------------------");
    
    }

    public void SumCategory(){
        IoManager.print("----------------카테고리 합계 검색 ----------------");
        ListAccountBook();
        String findCategory = IoManager.input("검색할 카테고리 >");
        int count =repository.findByCategoryCount(findCategory);
        IoManager.print(findCategory+"에 해당하는 카테고리는 총" + count + "개의 있습니다.");
    }
    
    public void SortedMoney(){
        IoManager.print("----------------금액 내림차순 검색 ----------------");
        
    }
}
