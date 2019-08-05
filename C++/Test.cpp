#include<iostream>
#include<string>
#include<vector>

using namespace std;
int fib(int n);

int main(){

    cout << "hello " << endl;
    cout << fib(10) << endl;
    return 0;
}

int fib(int n){
    if(n <= 2){
        return 1;
    }else{
       return fib(n-1) + fib(n-2);
    }
}