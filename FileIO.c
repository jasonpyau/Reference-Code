#include <stdio.h>
#include <string.h>
#include <ctype.h>

#define MAX_LEN 1000

int main () {
    
    FILE *file = fopen("file.txt" ,"a");
    fprintf(file, "%s%s", "Hello, world!\n",
    "The quick brown fox jumps over the lazy dog.");
    fclose(file);
    
    file = fopen("file.txt" , "r");
    if (file == NULL) {
        printf("Error opening file.");
        return -1;
    }
    
    char str[MAX_LEN];
    int i = 0;
    char c;
    
    while ((c = fgetc(file)) != EOF && i < MAX_LEN-1) {
        // check character
        if ((c >= ' ' && c <= '~') || c == '\n')
            str[i++] = c;
    }
    str[i] = '\0';
    fclose(file);
    
    printf("%s\n", str);
    printf("String Length: %ld\n", strlen(str));
    return 0;
}
