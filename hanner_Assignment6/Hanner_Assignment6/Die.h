#ifndef DIE_H
#define DIE_H

class Die
{
private:
	int dieValue = 0;
public:
	Die();
	void roll();
	int getValue();
};
#endif

