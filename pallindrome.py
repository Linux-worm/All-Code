def pallindrome(self):
	string = input('String please\n')
	string = string.lower()
	flag = False
	for i in range(0, len(string)):
		if (string[i] == string[len(string) - 1 - i]):
			return 'Yes'
		else:
			return 'No'
print(pallindrome(0))
