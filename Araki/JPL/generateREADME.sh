
chapters=`ls -d ch*`

for chapter in $chapters; do
    echo generate README for $chapter
    cd $chapter
    echo '# 演習問題一覧' > README.md 
    find */ -name README.md | xargs -I ARG sed s:演習問題:'## ARG': ARG | sed s/========// | sed s:/README.md:: >> README.md
    cd ..
done


