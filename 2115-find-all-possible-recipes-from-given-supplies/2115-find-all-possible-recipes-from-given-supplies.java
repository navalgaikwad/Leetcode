class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> set = new HashSet<>();
        for(String supplie:supplies) {
            set.add(supplie);
        }
        boolean found = true;
        List<String> result = new ArrayList<>();
        while(found) {
            found = false;
            for(int i=0; i<recipes.length; i++) {
                if(set.contains(recipes[i])) { //it will start checking for bread which we have already added
                    continue;
                }
                
                List<String> ingredient = ingredients.get(i);
                boolean flag = true;
                for(String ingred:ingredient) {
                    if(!set.contains(ingred)) {//not important
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    found = true;
                    set.add(recipes[i]);
                    result.add(recipes[i]);
                }
            }
        }
        return result;
    }
}

