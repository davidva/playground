# Usage

```elixir
> iex parallel.ex
iex(1)> slow_double = fn(x) -> :timer.sleep(1000); x * 2 end
#Function<6.90072148/1 in :erl_eval.expr/5>
iex(2)> :timer.tc(fn() -> Enum.map([1, 2, 3, 4], slow_double) end)
{4004790, [2, 4, 6, 8]}
iex(3)> :timer.tc(fn() -> Parallel.map([1, 2, 3, 4], slow_double) end
{1000481, [2, 4, 6, 8]}
```
