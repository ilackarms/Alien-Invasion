#include "room.h"
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
using namespace std;
room::room()
{
}

room::room(int room_difficulty, string in_name, string in_description)
{
    difficulty = room_difficulty;
    name = in_name;
    description = in_description;
    numberofmonsters = 0;

    if (room_difficulty!=0)
    {
        srand(time(NULL));
        numberofmonsters = ((rand()%3+difficulty));
        monster_list = new monster* [numberofmonsters];
        generate_monsters();
    }
}

void room::generate_monsters()
{


    switch (difficulty)
    {
    case 0:
        break;
    case 1:
        for (int i=0; i<numberofmonsters;i++){
            if (rand()%2==1)
                monster_list[i]=new monster('g');
            else
                monster_list[i]=new monster('w');}
        break;
    case 2:
        for (int i=0; i<numberofmonsters;i++){
            int chance = rand()%2;
            if (chance==1)
                monster_list[i]=new monster('o');
            else
                monster_list[i]=new monster('g');}
        break;
    case 3:
        for (int i=0; i<numberofmonsters;i++){
            int chance = rand()%3;
            if (chance==1)
                monster_list[i]=new monster('o');
            if (chance==2)
                monster_list[i]=new monster('g');
            if (chance==0)
                monster_list[i]=new monster('f');}
        break;
    case 4:
        for (int i=0; i<numberofmonsters;i++){
            int chance = rand()%3;
            if (chance==1)
                monster_list[i]=new monster('o');
            if (chance==2)
                monster_list[i]=new monster('o');
            if (chance==0)
                monster_list[i]=new monster('h');}
        break;
    case 5:
        for (int i=0; i<numberofmonsters;i++){
            int chance = rand()%4;
            if (chance==1 || chance == 3)
                monster_list[i]=new monster('h');
            if (chance==2)
                monster_list[i]=new monster('f');
            if (chance==0)
                monster_list[i]=new monster('g');}
        break;
    }
}
void room::room_info()
{
    cout << name << endl;
    cout << description << endl;
    if (difficulty!=0)
    {
        cout << "Monster List: " << endl;
        for (int i=0; i<numberofmonsters; i++)
        {
            cout << i << ". "<<monster_list[i]->name << endl;
        }
    }
}
