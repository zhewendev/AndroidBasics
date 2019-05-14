package com.vivo.wenruan.aidlbasicdemo.test;

import android.app.Service;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import static android.content.ContentValues.TAG;

public class BookManagerService extends Service {

        @Override
        public void addBook(Book book) throws RemoteException {
            mBookList.add(book);
            final int bookCount = mBookList.size();
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(BookManagerService.this,
                            String.format("添加了一本新书, 现在有%d本", bookCount), Toast.LENGTH_SHORT).show();
                }
            });
            Log.d(TAG, String.format("添加了一本新书, 现在有%d本", bookCount));
            Log.d(TAG, "currentThread = " + Thread.currentThread().getName());
        }

        @Override
        public List<Book> getBookList() throws RemoteException {
            return mBookList;
        }
    };

}
