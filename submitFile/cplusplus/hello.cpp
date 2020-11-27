#include <bits/stdc++.h>
using namespace std;

#define rep(i,a,n) for (int i=a;i<n;i++)
#define per(i,a,n) for (int i=n-1;i>=a;i--)
#define pb push_back
#define mp make_pair
#define all(x) (x).begin(),(x).end()
#define fi first
#define se second
#define SZ(x) ((int)(x).size())
typedef long long ll;
typedef double db;
typedef vector<int> VI;
typedef pair<int,int> PII;
typedef pair<long long,int> PLI;
const ll mod=1000000007;
//mt19937_64 mrand(random_device{}()); 
//int rnd(int x) { return mrand() % x;}
ll powmod(ll a,ll b) {ll res=1;a%=mod; assert(b>=0); for(;b;b>>=1){if(b&1)res=res*a%mod;a=a*a%mod;}return res;}
ll gcd(ll a,ll b) {return b?gcd(b,a%b):a;}

int n,m;
db a[100066],b[100066];
db sa[100066],sb[100066];

bool solve(db w)
{
	for(int i=1;i<=n;i++)
	{
		if(sa[i]<=w)continue;
		int cnt=sa[i]-w;
		int p=lower_bound(sb+1,sb+m+1,w+i)-sb;
		if(p<=cnt&&p<=m)return true;
	}return false;
}

int main()
{
	scanf("%d",&n);
	for(int i=1;i<=n;i++)
	{
		scanf("%lf%lf",&a[i],&b[i]);
	}
	sort(a+1,a+n+1,greater<db>());
	sort(b+1,b+n+1,greater<db>());
	m=n;
	while(n>0&&a[n]<1)n--;
	while(m>0&&b[m]<1)m--;
	for(int i=1;i<=n;i++)sa[i]=sa[i-1]+a[i]-1;
	for(int i=1;i<=m;i++)sb[i]=sb[i-1]+b[i]-1;
	db l=0,r=100000000;
	while(r-l>1e-5)
	{
		db mid=(l+r)/2;
		if(solve(mid))l=mid;
		else r=mid;
	}
	printf("%.4f\n",l);
	return 0;
}
