#include <iostream>

using namespace std;

void printArray(int *arr, int length);

int main(){
	int arr[] = {4,6,7,8,3};
	int length = sizeof(arr)/sizeof(*arr);
	printArray(arr, length);

	for (int j = 1; j < length; j++){
		int key = arr[j];
		cout << "Key " << arr[j] << endl;
		int i = j - 1;
		while(i >= 0 && arr[i] < key){
			arr[i+1] = arr[i];
			i= i - 1;
		}
		arr[i+1] = key;
	}

	printArray(arr, length);
    
    cout << endl;
    return 0;
}

void printArray(int *arr, int length){
	for (int i = 0; i < length; ++i)
	{
		if (i == 0){
			cout << "[";
		}

		 cout << arr[i];
		 if(i != length -1){
		 	cout << ", ";
		 }else{
		 	cout << "]";
			cout << endl;
		 }
		 
	}
}