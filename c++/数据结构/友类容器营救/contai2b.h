class Random
{
friend class Rescue;

public:
	Random(double fSeed=INIT_SEED)
	{m_fSeed=fSeed;}
	double getRandom();

protected:
	double m_fSeed;
};

double Random::getRandom()
{
    m_fSeed=farc(cube(m_fSeed+PI));
	return m_fSeed;
}