# configure git for sparse checkout so we can optimize diskusage (ie. checkout only required folders)
# simply add a call to this script from jenkins job
git config core.sparsecheckout true
echo "org/gemoc/gemoc_language_workbench" > .git/info/sparse-checkout
echo "org/gemoc/execution" >> .git/info/sparse-checkout
echo "org/gemoc/sample_deployed" >> .git/info/sparse-checkout
git read-tree -m -u HEAD
# cd org/gemoc/gemoc_language_workbench