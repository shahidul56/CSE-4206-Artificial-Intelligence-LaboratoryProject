#include <iostream>
#include <bits/stdc++.h>

using namespace std;

struct state
{
    int box[9] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    int h = 0;
};

state best;
vector<state> v;


int heuristic(int a[9])
{
    int h = 0;

    for(int i = 1; i <= 7; i++)
    {
        for(int j = i+1; j <= 8; j++)
        {
            if(a[i] != a[j] && (abs(i - j) != abs(a[i] - a[j])))
                h++;
        }
    }
    return h;
}

int main()
{
    int num;
    state s;
    cout<<"enter queen position:"<<endl;
    for(int i=1;i<=8;i++)
    {

        cin>>num;
        s.box[i]=num;
    }
    s.h=heuristic(s.box);
    cout<<"fitness value is : "<<s.h;
}

